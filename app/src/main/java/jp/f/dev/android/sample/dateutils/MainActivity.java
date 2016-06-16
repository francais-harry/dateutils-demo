package jp.f.dev.android.sample.dateutils;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.text.format.DateUtils;

import java.util.Date;

import jp.f.dev.android.sample.dateutils.databinding.ActivityMainBinding;

import static android.text.format.DateUtils.FORMAT_ABBREV_ALL;
import static android.text.format.DateUtils.FORMAT_NUMERIC_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_TIME;
import static android.text.format.DateUtils.FORMAT_SHOW_WEEKDAY;
import static android.text.format.DateUtils.FORMAT_SHOW_YEAR;
import static android.text.format.DateUtils.formatDateTime;
import static android.text.format.DateUtils.getRelativeTimeSpanString;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        long now = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();

        builder.append("DateUtils.formatDateTime demo\n\n");

        builder.append("FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_SHOW_WEEKDAY | FORMAT_ABBREV_ALL\n");
        builder.append(formatDateTime(this, now, FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_SHOW_WEEKDAY | FORMAT_ABBREV_ALL));
        builder.append("\n\n");

        builder.append("FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_SHOW_WEEKDAY\n");
        builder.append(formatDateTime(this, now, FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_SHOW_WEEKDAY));
        builder.append("\n\n");

        builder.append("FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_NUMERIC_DATE\n");
        builder.append(formatDateTime(this, now, FORMAT_SHOW_YEAR | FORMAT_SHOW_DATE | FORMAT_NUMERIC_DATE));
        builder.append("\n\n");

        builder.append("FORMAT_SHOW_TIME\n");
        builder.append(formatDateTime(this, now, FORMAT_SHOW_TIME));
        builder.append("\n\n");

        builder.append("DateUtils.getRelativeTimeSpanString demo\n\n");

        builder.append("Now\n");
        builder.append(getRelativeTimeSpanString(now));
        builder.append("\n\n");

        builder.append("One minute ago\n");
        builder.append(getRelativeTimeSpanString(now - DateUtils.MINUTE_IN_MILLIS));
        builder.append("\n\n");

        builder.append("One hour ago\n");
        builder.append(getRelativeTimeSpanString(now - DateUtils.HOUR_IN_MILLIS));
        builder.append("\n\n");

        builder.append("One day ago\n");
        builder.append(getRelativeTimeSpanString(now - DateUtils.DAY_IN_MILLIS));
        builder.append("\n\n");

        builder.append("Three days ago\n");
        builder.append(getRelativeTimeSpanString(now - DateUtils.DAY_IN_MILLIS * 3));
        builder.append("\n\n");

        builder.append("One week ago\n");
        builder.append(getRelativeTimeSpanString(now - DateUtils.WEEK_IN_MILLIS));
        builder.append("\n\n");

        builder.append("DateUtils API demo\n\n");

        builder.append("DateFormat.getLongDateFormat\n");
        builder.append(DateFormat.getLongDateFormat(this).format(new Date(now)));
        builder.append("\n\n");

        builder.append("DateFormat.getMediumDateFormat\n");
        builder.append(DateFormat.getMediumDateFormat(this).format(new Date(now)));
        builder.append("\n\n");

        builder.append("DateFormat.getDateFormat\n");
        builder.append(DateFormat.getDateFormat(this).format(new Date(now)));
        builder.append("\n\n");

        builder.append("DateFormat.getTimeFormat\n");
        builder.append(DateFormat.getTimeFormat(this).format(new Date(now)));
        builder.append("\n\n");

        mBinding.textView.setText(builder.toString());

    }
}
