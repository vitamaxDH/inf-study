package kr.co.infStudy;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/root-context.xml"})
public class MyTest {
 
	private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
	
    @Inject
    private DataSource ds;
       
    @Inject
    private SqlSessionFactory sqlFactory;
 
    @Test
    public void test() throws Exception{

        try(Connection conn = ds.getConnection()){
        	logger.info("\n MySQL 테스트 : {}", conn);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
   
  
    @Test
    public void factoryTest() {
        System.out.println(sqlFactory);
      
    }
  
    @Test
    public void sessionTest() throws Exception{
      
        try(SqlSession session = sqlFactory.openSession()) {
        	logger.info("\n MySQL 테스트 : {}", session);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}