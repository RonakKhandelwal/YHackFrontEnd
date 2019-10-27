package com.example.leetcoderecommendation.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Networking.NetworkingUtils;
import Utils.NetworkTask;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.CircularGauge;
import com.anychart.charts.Pie;
import com.anychart.charts.Radar;
import com.anychart.core.axes.Circular;
import com.anychart.core.gauge.pointers.Bar;
import com.anychart.core.radar.series.Line;
import com.anychart.enums.Align;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.graphics.vector.Fill;
import com.anychart.graphics.vector.SolidFill;
import com.anychart.graphics.vector.text.HAlign;
import com.anychart.graphics.vector.text.VAlign;
import com.example.leetcoderecommendation.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        AnyChartView anyChartView = root.findViewById(R.id.circular_view);
        AnyChartView anyChartView1 = root.findViewById(R.id.pie_chart);
        anyChartView1.setProgressBar(root.findViewById(R.id.progress_bar));
        APIlib.getInstance().setActiveAnyChartView(anyChartView1);
        //Creating the Pie chart
        Pie pie = AnyChart.pie();
        List<DataEntry> pieData = new ArrayList<>();
        pieData.add(new ValueDataEntry("Easy", 60));
        pieData.add(new ValueDataEntry("Medium", 67));
        pieData.add(new ValueDataEntry("Hard", 13));
        pie.data(pieData);
        pie.labels().position("outside");
        anyChartView1.setChart(pie);


//        Creating the Radar
        anyChartView.setProgressBar(root.findViewById(R.id.progress_bar));
        APIlib.getInstance().setActiveAnyChartView(anyChartView);
        Radar radar = AnyChart.radar();
        radar.yScale().minimum(0d);
        radar.yScale().minimumGap(0d);
        radar.yScale().ticks().interval(30d);
        radar.xAxis().labels().padding(5d, 5d, 5d, 5d);

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Dynamic Programming", 30));
        data.add(new ValueDataEntry("Array", 60));
        data.add(new ValueDataEntry("Graph", 10));
        data.add(new ValueDataEntry("String", 30));
        data.add(new ValueDataEntry("Stacks and Queues", 55));
        data.add(new ValueDataEntry("LinkedList", 15));
        data.add(new ValueDataEntry("Tree", 32));
        data.add(new ValueDataEntry("Advanced Data Structures", 14));

        Line line = radar.line(data);
        line.name("User");
        line.markers()
                .enabled(true)
                .type(MarkerType.CIRCLE)
                .size(3d);

//        radar.tooltip().format("Value: {%Value}");
        anyChartView.setChart(radar);

//        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(manager);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
//        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
//        NetworkTask.testApi();
    }
}