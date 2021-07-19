package com.merck.catalog;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.merck.catalog.admin.dao.CmmnCdDAO;
import com.merck.catalog.admin.model.TbSaa001m;

@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
	public class SAATableTest {

	    @Inject
	    private CmmnCdDAO cmmnDAO;

	    // 현재시간 출력 테스트
	    @Test
	    public void testTime() throws Exception {
	        System.out.println(cmmnDAO.getTime());
	    }

	    @Test
	    public void testInser() throws Exception {
	    	TbSaa001m tbSaa001mVO = new TbSaa001m();
	        tbSaa001mVO.setCmmnCdId("TEST111");
	        tbSaa001mVO.setCmmnCdIdNm("테스트111");
	        
	        cmmnDAO.insert(tbSaa001mVO);
	    }

	    @Test
	    public void testReadAll() throws Exception {
	        cmmnDAO.selectAll();
	    }

	}
