package com.qiyuesuo.thb.server;

import com.qiyuesuo.thb.server.entity.FileEntity;
import com.qiyuesuo.thb.server.mapper.FileMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	@Autowired
	FileMapper fileMapper;

	@Test
	public void test1() {
		FileEntity fileEntity = new FileEntity();
		fileEntity.setAddress("1212");
		fileEntity.setCreatetime(new Date());
		fileEntity.setOriginalname("13434.txt");
		fileEntity.setSize(32432L);
		fileEntity.setType("eqwewq");
		fileMapper.saveFile(fileEntity);
		List<FileEntity> fileEntities = fileMapper.queryFileList();
		System.out.println(fileEntities);
	}

}
