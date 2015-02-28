package j2setest.effective.e30;

public enum TestEnum {

	RENHO0("*") {
		@Override
		String getRenho() {
			return "String renho0";
		}
	},
	RENHO1("#") {
		@Override
		String getRenho() {
			return "String renho1";
		}
	};
	abstract String getRenho();
	private final String symbol;
	
	private TestEnum(String symbol) {
		this.symbol = symbol;
	}

	public static void main(String [] args) {
//		System.out.println(TestEnum.RENHO0);
//		System.out.println(TestEnum.RENHO0.getRenho());
//		
//		System.out.println(TestEnum.RENHO1);
//		System.out.println(TestEnum.RENHO1.getRenho());
		
		for(TestEnum te:TestEnum.values()) {
			System.out.println(te + ":" + te.getRenho() + ":" + te.symbol);
		}
	}
	
}
