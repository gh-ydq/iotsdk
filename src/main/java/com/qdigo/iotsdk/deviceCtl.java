package main.java.com.qdigo.iotsdk;

import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;;

public class deviceCtl {

	static int i_seq = 0;
	

	/**
	 * ������ڹ���ԱԶ�̿��Ƴ��������û�app��������������
	 * @param imei��9λ��ʮ������
	 * ��Ӧ������	3	SEQ	1	���1										
	 * @return
	 */
	public boolean Ignition(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(3).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * Ϩ�����ڹ���ԱԶ�̿��Ƴ��������û�app������������
	 * @param imei��9λ��ʮ������
	 * ��Ӧ������	3	SEQ	1	Ϩ��0
	 * @return
	 */
	public boolean Flameout(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(3).param("0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * ����GPS����Ƶ�ʺ�����ʱ��PTIMEʱ�䣬���ڹ���ԱԶ�̿��Ƴ��������û�app������������
	 * @param imei��9λ��ʮ������
	 * ����	7	SEQ	PTIME	�޸�GPS����Ƶ�ʺ�����ʱ��PTIME (��)
	 * pTime ��λ���� (�޸�GPS����Ƶ�ʺ�����ʱ��)��������޸���0
	 * @return
	 */
	public boolean SetPTIME(long imei,int pTime) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(7).param(String.valueOf(pTime)+",0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * �����޸Ĺرյ�����������ʱ�䣬���ڹ���ԱԶ�̿��Ƴ��������û�app������������
	 * @param imei��9λ��ʮ������
	 * ����	7	SEQ	HTIME	�޸Ĺرյ�����������ʱ�䣨HTIME �룩 
	 * hTime ��λ���� (�޸Ĺرյ�����������ʱ��)��������޸���0
	 * @return
	 */
	public boolean SetHTIME(long imei,int hTime) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(7).param("0," + String.valueOf(hTime)).build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
		

	/**
	 * Ӳ����
	 * @param imei��9λ��ʮ������
	 * ��Ӧ������	8	SEQ	1	Ӳ����
	 * @return
	 */
	public boolean Reboot(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(8).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * ����Ӳ��������
	 * @param imei��9λ��ʮ������
	 * ��Ӧ������	12	SEQ	1	����Ӳ�������ȣ� bit0~bit3: 1~8,��ʾ8��Ӳ�������ȣ� 8���������
	 * grade Ϊ������ֵ�����뷶Χ��1-8
	 * @return
	 */
	public boolean SetSensitivity(long imei,int grade) {
		String param = String.valueOf((char) grade);
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(12).param(param).build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * ��������������������˼�����û���app�ϵ��������ʱ�����
	 * @param imei��9λ��ʮ������
	 * ��Ӧ������	24	SEQ	1  ����
	 * @return
	 */
	public boolean Lock(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(24).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	
	/**
	 * ����(����)���û���app�ϵ��������ʱ�����
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	24	SEQ	0	����
	 * @return
	 */
	public boolean Unlock(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(24).param("0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * �Զ��������ã������ã�������óɹ������ڶϵ��������ӻ��Զ�����
	 * @param imei��9λ��ʮ������ 
	 * ����	27	SEQ	1	�Զ��������ã�1�Զ�
	 * @return
	 */
	public boolean AutoLockOn(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(27).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * �Զ��������ã������ã�������óɹ������ڶϵ����Ҫ�ֶ�����
	 * @param imei��9λ��ʮ������ 
	 * ����	27	SEQ	0	�Զ��������ã�0�ֶ�
	 * @return
	 */
	public boolean AutoLockOff(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(27).param("0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}


	/**
	 * ���������ϱ�����������
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	30	SEQ	1	���������ϱ��������������豸���յ�����������һ��������
	 * @return
	 */
	public boolean ReqHearbeat(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(30).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	
	/**
	 * Ѱ����ʼ
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	41	SEQ	1	 1 Ѱ����ʼ
	 * @return
	 */
	public boolean SeekStart(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(41).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}

	/**
	 * Ѱ������
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	41	SEQ	0	 0 Ѱ������
	 * @return
	 */
	public boolean SeekEnd(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(41).param("0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * �ϵ�
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	42	SEQ 1���ϵ�										
	 * @return
	 */
	public boolean Fire(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(42).param("1").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}

	/**
	 * �ϵ�
	 * @param imei��9λ��ʮ������ 
	 * ��Ӧ������	42	SEQ 0���ϵ�										
	 * @return
	 */
	public boolean Shutdown(long imei) {
		
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(42).param("0").build();
		
		byte[]  cmd = builder.toCmd();

		return Connection.getInstance().SendCmd(cmd);
	}
	

	/**
	 * ���õ�λ
	 * @param imei��9λ��ʮ������ 
	 * @param grade��1-3������
	 * ��Ӧ������	44	SEQ		��λһ�ֽڣ�1-3, ֵԽ���ٶ�Խ�죨1��,2�еȣ�3��)									
	 * @return
	 */
	public boolean SetStall(long imei,int grade){
		
		String param = String.valueOf((char) grade);
		CmdBuilder builder = new CmdBuilder.Builder().imei(imei).seq((char)i_seq).cmd(12).param(param).build();
		
		byte[]  cmd = builder.toCmd();
		
		return Connection.getInstance().SendCmd(cmd);
		
	}
	
}
