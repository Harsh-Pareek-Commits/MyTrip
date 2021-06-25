package com.g5.tms.service;

import java.util.Comparator;

import com.g5.tms.entities.Package;

public class PackageSortingConfiguration {
	class SortbyPriceAsc implements Comparator<Package> {
		@Override
		public int compare(Package a, Package b) {
			return (int) (a.getPackageCost() - b.getPackageCost());
		}

	}
	class SortbyPriceDes implements Comparator<Package> {
		@Override
		public int compare(Package a, Package b) {
			return (int) (b.getPackageCost() - a.getPackageCost());
		}

	}
	class SortbynameAsc implements Comparator<Package> {
		public int compare(Package a, Package b) {
			return a.getPackageName().compareTo(b.getPackageName());
		}
	}
	class SortbynameDes implements Comparator<Package> {
		public int compare(Package a, Package b) {
			return b.getPackageName().compareTo(a.getPackageName());
		}
	}
	class SortbyArrTimeAsc implements Comparator<Package> {
		public int compare(Package a, Package b) {
			return a.getRoute().getArrivalTime().compareTo(b.getRoute().getArrivalTime());
		}
	}
	class SortbyArrTimeDes implements Comparator<Package> {
		public int compare(Package a, Package b) {
			return b.getRoute().getArrivalTime().compareTo(a.getRoute().getArrivalTime());
		}
	}
}
