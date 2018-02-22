package com.schibsted.sa.detskjer.ui.searchBarFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.schibsted.sa.detskjer.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchBarFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    private EcApiUrlHelper urlHelper;

    private DatePickerDialog datePickerDialog;

    @BindView(R.id.search_bar_date_button)
    protected Button dateButton;

    private void setupDatePicker() {
        Date now = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        datePickerDialog = new DatePickerDialog(
                getContext(),
                this,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
        );
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupDatePicker();

        urlHelper = new EcApiUrlHelper();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.search_bar_fragment, container, false);

        ButterKnife.bind(this, inflatedView);

        dateButton.setOnClickListener(view -> {
            datePickerDialog.show();
        });

        return inflatedView;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        urlHelper.searchByDate(new GregorianCalendar(year, month, day).getTime());

        datePickerDialog.hide();
    }
}
