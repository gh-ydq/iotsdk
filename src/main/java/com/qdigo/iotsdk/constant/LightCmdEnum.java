package com.qdigo.iotsdk.constant;

public enum LightCmdEnum {
	LIGHT_START_CMD((char)1,"02","1","开灯"),
	LIGHT_STOP_CMD((char)1,"02","0","关灯"),
	LIGHT_ADJUST_CMD((char)3,"02","1","灯光亮度调节"),
	ONE_KEY_TEST_CMD((char)4,"02","1","一键检测"),
	IMEI_KEY_TEST_CMD((char)4,"02","imei","具体设备检查"),
	UPDATE_INSIDE_IMEI_CMD((char)11,"02","","修改设备内置IMEI，防止设备飞号，便于修复"),
	UPDATE_INSIDE_PARAM_CMD((char)12,"02","","修改设备内置参数"),
	SEND_SMS_CMD((char)33,"02","1","发送短信，具体参数定义参见短信包格式"),
	;


	private char cmd;
	private String param;
	private String dec;
	private String busiType;

	private LightCmdEnum(char cmd,String busiType, String param, String dec){
		this.cmd = cmd;
		this.param = param;
		this.dec = dec;
		this.busiType = busiType;

	}

	public static LightCmdEnum getLightStartCmd(char cmd){
		LightCmdEnum[] lightCmdEnums = LightCmdEnum.values();
		for(LightCmdEnum lightCmdEnum : lightCmdEnums){
			if(lightCmdEnum.cmd == cmd){
				return lightCmdEnum;
			}
		}
		return null;
	}

	public char getCmd() {
		return cmd;
	}

	public void setCmd(char cmd) {
		this.cmd = cmd;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
}
