package org.smartregister.immunization.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.domain.Alert;
import org.smartregister.immunization.R;
import org.smartregister.immunization.adapter.VaccineCardAdapter;
import org.smartregister.immunization.domain.GroupState;
import org.smartregister.immunization.domain.State;
import org.smartregister.immunization.domain.Vaccine;
import org.smartregister.immunization.domain.VaccineWrapper;
import org.smartregister.immunization.listener.VaccineCardAdapterLoadingListener;
import org.smartregister.immunization.util.VaccinatorUtils;
import org.smartregister.util.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jason Rogena - jrogena@ona.io on 21/02/2017.
 */

public class VaccineGroup extends LinearLayout implements View.OnClickListener {
    private Context context;
    private TextView nameTV;
    private TextView recordAllTV;
    private ExpandableHeightGridView vaccinesGV;
    private VaccineCardAdapter vaccineCardAdapter;
    private org.smartregister.immunization.domain.jsonmapping.VaccineGroup vaccineData;
    private CommonPersonObjectClient childDetails;
    private List<Vaccine> vaccineList;
    private List<Alert> alertList;
    private GroupState groupState;
    private OnRecordAllClickListener onRecordAllClickListener;
    private OnVaccineClickedListener onVaccineClickedListener;
    private OnVaccineUndoClickListener onVaccineUndoClickListener;
    private SimpleDateFormat READABLE_DATE_FORMAT;
    private boolean modalOpen;
    private String type;

    private boolean isChildActive = true;
    private VaccineCardAdapterLoadingListener vaccineCardAdapterLoadingListener;

    public VaccineGroup(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_vaccine_group, this, true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        READABLE_DATE_FORMAT = new SimpleDateFormat("dd MMMM, yyyy");

        nameTV = findViewById(R.id.name_tv);
        vaccinesGV = findViewById(R.id.vaccines_gv);
        vaccinesGV.setExpanded(true);
        recordAllTV = findViewById(R.id.record_all_tv);
        recordAllTV.setOnClickListener(this);
    }

    public VaccineGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VaccineGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi (Build.VERSION_CODES.LOLLIPOP)
    public VaccineGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public CommonPersonObjectClient getChildDetails() {
        return childDetails;
    }

    public org.smartregister.immunization.domain.jsonmapping.VaccineGroup getVaccineData() {
        return vaccineData;
    }

    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(List<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<Alert> alertList) {
        this.alertList = alertList;
    }

    public void setData(org.smartregister.immunization.domain.jsonmapping.VaccineGroup vaccineData,
                        CommonPersonObjectClient childDetails, List<Vaccine> vaccines, List<Alert> alerts, String type) {
        this.vaccineData = vaccineData;
        this.childDetails = childDetails;
        vaccineList = vaccines;
        alertList = alerts;
        this.type = type;
        updateViews();
    }

    /**
     * This method will update all views, including vaccine cards in this group
     */
    public void updateViews() {
        updateViews(null);
    }

    /**
     * This method will update vaccine group views, and the vaccine cards corresponding to the list of {@link
     * VaccineWrapper}s specified
     *
     * @param vaccinesToUpdate
     *         List of vaccines who's views we want updated, or NULL if we want to update all vaccine views
     */
    public void updateViews(ArrayList<VaccineWrapper> vaccinesToUpdate) {
        groupState = GroupState.IN_PAST;
        if (vaccineData != null) {
            String dobString = Utils.getValue(childDetails.getColumnmaps(), "dob", false);
            DateTime dateTime = new DateTime(dobString);
            Date dob = dateTime.toDate();
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);

            long timeDiff = today.getTimeInMillis() - dob.getTime();

            if (timeDiff < today.getTimeInMillis()) {
                groupState = GroupState.IN_PAST;
            } else if (timeDiff > (today.getTimeInMillis() + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))) {
                groupState = GroupState.IN_FUTURE;
            } else {
                groupState = GroupState.CURRENT;
            }
            updateStatusViews();
            updateVaccineCards(vaccinesToUpdate);
        }
    }

    private void updateStatusViews() {
        switch (groupState) {
            case IN_PAST:
                nameTV.setText(VaccinatorUtils.getTranslatedGroupName(context, vaccineData));
                break;
            case CURRENT:
                nameTV.setText(String.format(context.getString(R.string.due_),
                        VaccinatorUtils.getTranslatedGroupName(context, vaccineData), context.getString(R.string.today)));
                break;
            case IN_FUTURE:
                String dobString = Utils.getValue(childDetails.getColumnmaps(), "dob", false);
                Calendar dobCalender = Calendar.getInstance();
                DateTime dateTime = new DateTime(dobString);
                dobCalender.setTime(dateTime.toDate());
                dobCalender.add(Calendar.DATE, vaccineData.days_after_birth_due);
                nameTV.setText(String.format(context.getString(R.string.due_),
                        VaccinatorUtils.getTranslatedGroupName(context, vaccineData),
                        READABLE_DATE_FORMAT.format(dobCalender.getTime())));
                break;
            default:
                break;
        }
    }

    private void updateVaccineCards(ArrayList<VaccineWrapper> vaccinesToUpdate) {
        if (vaccineCardAdapter == null) {
            vaccineCardAdapter = new VaccineCardAdapter(context, this, type, vaccineList, alertList);
            vaccineCardAdapter.setChildActive(isChildActive);
            vaccinesGV.setAdapter(vaccineCardAdapter);

            vaccinesGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    if (!(v instanceof VaccineCard)) {
                        return;
                    }

                    v.setEnabled(false);

                    VaccineCard vaccineCard = (VaccineCard) v;
                    State state = vaccineCard.getState();
                    if (state != null) {
                        switch (state) {
                            case DUE:
                            case OVERDUE:
                                if (onVaccineClickedListener != null) {
                                    onVaccineClickedListener.onClick(VaccineGroup.this, vaccineCard.getVaccineWrapper());
                                }
                                break;
                            case DONE_CAN_BE_UNDONE:
                                onUndoClick(vaccineCard);
                                break;
                            default:
                                break;
                        }
                    }

                    v.setEnabled(true);
                }
            });
        }

        if (vaccineCardAdapter != null && vaccinesToUpdate != null) {
            vaccineCardAdapter.update(vaccinesToUpdate);
            toggleRecordAllTV();
        }
    }

    public void onUndoClick(VaccineCard vaccineCard) {
        if (onVaccineUndoClickListener != null) {
            onVaccineUndoClickListener.onUndoClick(this, vaccineCard.getVaccineWrapper());
        }
    }

    public void toggleRecordAllTV() {
        if (vaccineCardAdapter.getDueVaccines().size() > 0 && isChildActive) {
            recordAllTV.setVisibility(VISIBLE);
        } else {
            recordAllTV.setVisibility(GONE);
        }
    }

    public void setOnVaccineUndoClickListener(OnVaccineUndoClickListener onVaccineUndoClickListener) {
        this.onVaccineUndoClickListener = onVaccineUndoClickListener;
    }

    public void setChildActive(boolean childActive) {
        isChildActive = childActive;
    }

    public void updateChildsActiveStatus() {
        toggleRecordAllTV();

        if (vaccineCardAdapter != null) {
            vaccineCardAdapter.setChildActive(isChildActive);
            vaccineCardAdapter.updateChildsActiveStatus();
        }

        if (vaccinesGV != null) {
            vaccinesGV.invalidateViews();
        }
    }

    @Override
    public void onClick(View v) {
        v.setEnabled(false);
        if ((v.equals(recordAllTV)) && (onRecordAllClickListener != null && vaccineCardAdapter != null)) {
            onRecordAllClickListener.onClick(this, vaccineCardAdapter.getDueVaccines());
        }
        v.setEnabled(true);
    }

    public void setOnRecordAllClickListener(OnRecordAllClickListener onRecordAllClickListener) {
        this.onRecordAllClickListener = onRecordAllClickListener;
    }

    public void setOnVaccineClickedListener(OnVaccineClickedListener onVaccineClickedListener) {
        this.onVaccineClickedListener = onVaccineClickedListener;
    }

    public ArrayList<VaccineWrapper> getDueVaccines() {
        if (vaccineCardAdapter != null) {
            return vaccineCardAdapter.getDueVaccines();
        }
        return new ArrayList<VaccineWrapper>();
    }

    public ArrayList<VaccineWrapper> getAllVaccineWrappers() {
        if (vaccineCardAdapter != null) {
            return vaccineCardAdapter.getAllVaccineWrappers();
        }
        return new ArrayList<>();
    }

    public boolean isModalOpen() {
        return modalOpen;
    }

    public void setModalOpen(boolean modalOpen) {
        this.modalOpen = modalOpen;
    }

    public void updateWrapperStatus(ArrayList<VaccineWrapper> wrappers, String child) {
        if (vaccineCardAdapter != null) {
            vaccineCardAdapter.updateWrapperStatus(wrappers, child, childDetails);
        }
    }

    public void updateWrapper(VaccineWrapper wrapper) {
        if (vaccineCardAdapter != null) {
            vaccineCardAdapter.updateWrapper(wrapper);
        }
    }

    public ExpandableHeightGridView getVaccinesGV() {
        return vaccinesGV;
    }

    public VaccineCardAdapter getVaccineCardAdapter() {
        return vaccineCardAdapter;
    }

    public VaccineCardAdapterLoadingListener getVaccineCardAdapterLoadingListener() {
        return vaccineCardAdapterLoadingListener;
    }

    public void setVaccineCardAdapterLoadingListener(VaccineCardAdapterLoadingListener vaccineCardAdapterLoadingListener) {
        this.vaccineCardAdapterLoadingListener = vaccineCardAdapterLoadingListener;

        if (vaccineCardAdapterLoadingListener != null && vaccineCardAdapter != null) {
            vaccineCardAdapter.setVaccineCardAdapterLoadingListener(vaccineCardAdapterLoadingListener);
        }
    }

    public interface OnRecordAllClickListener {
        void onClick(VaccineGroup vaccineGroup, ArrayList<VaccineWrapper> dueVaccines);
    }

    public interface OnVaccineClickedListener {
        void onClick(VaccineGroup vaccineGroup, VaccineWrapper vaccine);
    }

    public interface OnVaccineUndoClickListener {
        void onUndoClick(VaccineGroup vaccineGroup, VaccineWrapper vaccine);

    }
}
