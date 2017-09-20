package com.qdigo.iotsdk.util;

public class CmdSeqUtil {
	public static byte gneratorCmdSeq(){
		byte seq = (byte) (Math.random()*127);
		return seq;
	}
}
