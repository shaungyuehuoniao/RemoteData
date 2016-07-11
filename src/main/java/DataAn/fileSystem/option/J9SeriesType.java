package DataAn.fileSystem.option;

public enum J9SeriesType {

	/**系列*/
	SERIES {
		@Override
		public String getName() {
			return "j9";
		}

		@Override
		public String getValue() {
			return "j9";
		}
	},
	/**星1*/
	STRA1 {
		@Override
		public String getName() {
			return "star1";
		}

		@Override
		public String getValue() {
			return "01";
		}
	},
	/**星2*/
	STRA2 {
		@Override
		public String getName() {
			return "star2";
		}

		@Override
		public String getValue() {
			return "02";
		}
	},
	/**星3*/
	STRA3 {
		@Override
		public String getName() {
			return "star3";
		}

		@Override
		public String getValue() {
			return "03";
		}
	},
	/**星4*/
	STRA4 {
		@Override
		public String getName() {
			return "star4";
		}

		@Override
		public String getValue() {
			return "04";
		}
	},
	/**星5*/
	STRA5 {
		@Override
		public String getName() {
			return "star5";
		}

		@Override
		public String getValue() {
			return "05";
		}
	};
	public abstract String getName();

	public abstract String getValue();

	public static J9SeriesType getJ9StarType(String type) {
		switch (type) {
		case "01":
			return J9SeriesType.STRA1;
			
		case "02":
			return J9SeriesType.STRA2;
			
		case "03":
			return J9SeriesType.STRA3;
			
		case "04":
			return J9SeriesType.STRA4;
			
		case "05":
			return J9SeriesType.STRA5;
			
		default:
			return null;
		}
	}
}
