package com.dream.qixing.mobile.util;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

	static {
		for (Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

}
