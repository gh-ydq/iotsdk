package com.qdigo.iotsdk;


/**
 * downstream commands begins with P(0)C(1)
 * @author Menggang
 *
 */
public class CmdBuilder {
	
	private static long CMD_IMEI = 0;
	private static int CMD_SEQ = 0;
	private static int CMD_CMD = 0;
	private static String CMD_PARAM = "0";
	private static String BUSI_TYPE_PARAM="02";
	
	public static class Builder {
		
		private long imei;
		private int seq;
		private int cmd;
		private String busiType;
		private String param;
		
		public Builder imei(long val) {
			imei = val;
			return this;
		}
		
		public Builder seq(byte val) {
			seq = val;
			return this;
		}
		
		public Builder cmd(int val) {
			cmd = val;
			return this;
		}
		
		public Builder param(String val) {
			param = val;
			return this;
		}
		public Builder busiType(String busiTypeVal) {
			busiType = busiTypeVal;
			return this;
		}
		
		public CmdBuilder build() {
			return new CmdBuilder(this);
		}
	}
	
	private CmdBuilder(Builder b) {
		CmdBuilder.CMD_IMEI = b.imei;
		CmdBuilder.CMD_SEQ = b.seq;
		CmdBuilder.CMD_CMD = b.cmd;
		CmdBuilder.CMD_PARAM = b.param;
		CmdBuilder.BUSI_TYPE_PARAM = b.busiType;
	}
	
	public byte[] toCmd() {
		char[] param = CmdBuilder.CMD_PARAM.toCharArray();
		char[] busiTypeArray = CmdBuilder.BUSI_TYPE_PARAM.toCharArray();
		byte[] res = new byte[8+busiTypeArray.length+param.length];
		res[0] = (byte)'P';
		res[1] = (byte)'X';
		for(int i =0;i<busiTypeArray.length;i++)
		{
			res[2+i] = (byte) busiTypeArray[i];
		}
		res[2+busiTypeArray.length] = (byte) (CmdBuilder.CMD_IMEI>>24 & 0xFF);
		res[3+busiTypeArray.length] = (byte) ((CmdBuilder.CMD_IMEI>>16) & 0xFF);
		res[4+busiTypeArray.length] = (byte) ((CmdBuilder.CMD_IMEI>>8) & 0xFF);
		res[5+busiTypeArray.length] = (byte) ((CmdBuilder.CMD_IMEI) & 0xFF);
		res[6+busiTypeArray.length] = (byte)((int)(Math.random() * 127));
		res[7+busiTypeArray.length] = (byte) CmdBuilder.CMD_CMD;
		
		for(int i =0;i<param.length;i++)
		{
			res[8+busiTypeArray.length+i] = (byte) param[i];
		}

		return res;
	}
}
