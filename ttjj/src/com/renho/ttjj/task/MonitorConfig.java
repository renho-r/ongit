package com.renho.ttjj.task;

public class MonitorConfig {

	private String jjdm;
	private Double gszlu;
	private Double gszld;
	private Double gszu;
	private Double gszd;
	private boolean sendMail;
	private Integer nextMinus;
	private Integer step;
	
	private String url;
	
	public MonitorConfig(String jjdm) {
		this(jjdm, 2.0, 2.0, 1.0, 2.0, false, 5, 30);
	}
	
	public MonitorConfig(String jjdm, Double gszlu, Double gszld, Double gszu, Double gszd, boolean sendMail, Integer nextMinus, Integer step) {
		this.jjdm = jjdm;
		this.gszlu = gszlu;
		this.gszld = gszld;
		this.gszu = gszu;
		this.gszd = gszd;
		this.url = "http://fundgz.1234567.com.cn/js/" + jjdm + ".js?rt=";
		this.sendMail = sendMail;
		this.nextMinus = nextMinus;
		this.step = step;
	}
	
	public static MonitorConfig defaultMonitorConfig(String jjdm) {
		return new MonitorConfig(jjdm);
	}

	public String getJjdm() {
		return jjdm;
	}

	public void setJjdm(String jjdm) {
		this.jjdm = jjdm;
	}

	public Double getGszlu() {
		return gszlu;
	}

	public void setGszlu(Double gszlu) {
		this.gszlu = gszlu;
	}

	public Double getGszld() {
		return gszld;
	}

	public void setGszld(Double gszld) {
		this.gszld = gszld;
	}

	public Double getGszu() {
		return gszu;
	}

	public void setGszu(Double gszu) {
		this.gszu = gszu;
	}

	public Double getGszd() {
		return gszd;
	}

	public void setGszd(Double gszd) {
		this.gszd = gszd;
	}

	public boolean isSendMail() {
		return sendMail;
	}

	public void setSendMail(boolean sendMail) {
		this.sendMail = sendMail;
	}

	public Integer getNextMinus() {
		return nextMinus;
	}

	public void setNextMinus(Integer nextMinus) {
		this.nextMinus = nextMinus;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
