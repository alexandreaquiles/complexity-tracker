package com.deveficiente.complexitytracker.reports;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.deveficiente.complexitytracker.generatehistory.ComplexityHistory;

public class ComplexityMetricPerClassBarData {

	private LinkedHashSet<String> labels = new LinkedHashSet<>();
	private List<BarGroupedDataSet> datasets = new ArrayList<>();

	public ComplexityMetricPerClassBarData(List<ComplexityHistory> history) {
		this.labels.addAll(history.stream().map(ComplexityHistory::getHash)
				.collect(Collectors.toCollection(() -> new LinkedHashSet<>())));
		
		List<Integer> cbos = history.stream()
			.map(ComplexityHistory :: getCbo)
			.collect(Collectors.toList());
		
		BarGroupedDataSet groupedCbos = new BarGroupedDataSet(cbos,"CBO","blue");
		this.datasets.add(groupedCbos);
		
		List<Integer> wmcs = history.stream()
				.map(ComplexityHistory :: getWmc)
				.collect(Collectors.toList());
		
		BarGroupedDataSet groupedWmcs = new BarGroupedDataSet(wmcs,"WMC","green");
		this.datasets.add(groupedWmcs);
		
		List<Integer> lcoms = history.stream()
				.map(ComplexityHistory :: getLcom)
				.collect(Collectors.toList());
		
		BarGroupedDataSet groupedLcoms = new BarGroupedDataSet(lcoms,"LCOM","yellow");
		this.datasets.add(groupedLcoms);
		
		List<Integer> loc = history.stream()
				.map(ComplexityHistory :: getLoc)
				.collect(Collectors.toList());
		
		BarGroupedDataSet groupedLoc = new BarGroupedDataSet(loc,"LOC","red");
		this.datasets.add(groupedLoc);
		
	}
	
	public LinkedHashSet<String> getLabels() {
		return labels;
	}

	public List<BarGroupedDataSet> getDatasets() {
		return datasets;
	}
}
