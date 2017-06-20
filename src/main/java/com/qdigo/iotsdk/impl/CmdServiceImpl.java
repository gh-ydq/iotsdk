package com.qdigo.iotsdk.impl;

import com.qdigo.iotsdk.Connection;
import com.qdigo.iotsdk.api.CmdService;
import com.qdigo.iotsdk.dto.pg.PGPacketDto;
import com.qdigo.iotsdk.dto.ph.PHPacketDto;
import com.qdigo.iotsdk.dto.pl.PLPacketDto;
import com.qdigo.iotsdk.service.PCService;
import com.qdigo.iotsdk.service.PGService;
import com.qdigo.iotsdk.service.PHService;
import com.qdigo.iotsdk.service.PLService;

import main.java.com.qdigo.iotsdk.dto.pc.PCPacketDto;

public class CmdServiceImpl implements CmdService {

	public void sendPGData(PGPacketDto pgPacketDto) {
		
		byte[] bytes = PGService.buildPGDataAray(pgPacketDto);
<<<<<<< Updated upstream
		Connection.getInstance(pgPacketDto.getIp(),pgPacketDto.getPort()).SendCmd(bytes);
=======
		Connection.getInstance().sendCmd(bytes);
>>>>>>> Stashed changes
	}
	
	public void sendPLData(PLPacketDto plPacketDto) {
		byte[] bytes = PLService.buildPLDataAray(plPacketDto);
<<<<<<< Updated upstream
		Connection.getInstance(plPacketDto.getIp(),plPacketDto.getPort()).SendCmd(bytes);
=======
		Connection.getInstance().sendCmd(bytes);
>>>>>>> Stashed changes
		
	}

	public void sendPHData(PHPacketDto phPacketDto) {
		byte[] bytes = PHService.buildPHDataAray(phPacketDto);
<<<<<<< Updated upstream
		Connection.getInstance(phPacketDto.getIp(),phPacketDto.getPort()).SendCmd(bytes);
=======
		Connection.getInstance().sendCmd(bytes);
>>>>>>> Stashed changes
		
	}

	public void sendPCData(PCPacketDto pcPacketDto) {
		byte[] bytes = PCService.buildPCDataAray(pcPacketDto);
<<<<<<< Updated upstream
		Connection.getInstance(pcPacketDto.getIp(),pcPacketDto.getPort()).SendCmd(bytes);
=======
		Connection.getInstance().sendCmd(bytes);
>>>>>>> Stashed changes
		
	}
	
	

	

}
