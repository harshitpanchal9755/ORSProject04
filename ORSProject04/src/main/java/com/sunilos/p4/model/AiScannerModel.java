//package com.sunilos.p4.model;
//
//import java.sql.Connection;
//import java.sql.JDBCType;
//import java.sql.PreparedStatement;
//
//import com.sunilos.p4.bean.AiScannerBean;
//import com.sunilos.p4.exception.ApplicationException;
//import com.sunilos.p4.exception.DuplicateRecordException;
//import com.sunilos.p4.util.JDBCDataSource;
//
//public class AiScannerModel extends BaseModel<AiScannerBean>{
//	
//
//	@Override
//	public AiScannerBean getBean() {
//		// TODO Auto-generated method stub
//		return new AiScannerBean();
//	}
//
//
//	@Override
//	public long add(AiScannerBean bean) throws ApplicationException, DuplicateRecordException {
//		Connection conn = null;
//		int pk = 0;
//		
//		AiScannerBean existBean = findByName(bean.getId());
//		
//		if(existBean != null) {
//			throw new DuplicateRecordException("Find By Name is already exist");
//		}
//		
//		try {
//			pk = nextPK();
//			conn = JDBCDataSource.getConnection();
//			conn.setAutoCommit(false);
//			System.out.println("module is start" + pk);
//			
//			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?)");
//			ps.setInt(1, pk);
//			ps.setString(2, bean.getName());
//			ps.setString(3, bean.getDescription());
//			ps.setString(4, bean.getType());
//			ps.setString(5, bean.getStatus());
//			ps.setString(6, bean.getCreatedBy());
//			ps.setString(7, bean.getModifiedBy());
//			ps.setTimestamp(8, bean.getCreatedDatetime());
//			ps.setTimestamp(9, bean.getModifiedDatetime());
//			ps.executeUpdate();
//			conn.commit();
//			ps.close();
//			
//		}
//		
//		catch (Exception e) {
//			
//			try {
//				conn.rollback();
//				
//			}catch(Exception ex) {
//				throw new ApplicationException("findbyADD Exception" + ex.getMessage());
//			}
//		}
//		
//		return ;
//	private AiScannerBean findByName(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	}
//
//	@Override
//	public void update(AiScannerBean bean) throws ApplicationException, DuplicateRecordException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getWhereClause(AiScannerBean bean) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getTable() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
