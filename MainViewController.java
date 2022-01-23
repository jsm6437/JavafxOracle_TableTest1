package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class MainViewController implements Initializable {
	@FXML
	private TableView<ModelTable> eEmp;
	@FXML
	private TableColumn<ModelTable, Integer> eEmpno;
	@FXML
	private TableColumn<ModelTable, String> eEname;
	@FXML
	private TableColumn<ModelTable, String> eJob;
	@FXML
	private TableColumn<ModelTable, Integer> eMgr;
	@FXML
	private TableColumn<ModelTable, Date> eHiredate;
	@FXML
	private TableColumn<ModelTable, Integer> eSal;
	@FXML
	private TableColumn<ModelTable, Integer> eComm;
	@FXML
	private TableColumn<ModelTable, Integer> eDeptno;
	
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Connection conn = DBConnection.getConnection();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from emp");
			while(rs.next()) {
				oblist.add(new ModelTable(rs.getInt("empno"),rs.getString("ename"),
						rs.getString("job"), rs.getInt("mgr"),rs.getDate("hiredate"),
						rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eEmpno.setCellValueFactory(new PropertyValueFactory<>("empno"));
		eEname.setCellValueFactory(new PropertyValueFactory<>("ename"));
		eJob.setCellValueFactory(new PropertyValueFactory<>("job"));
		eMgr.setCellValueFactory(new PropertyValueFactory<>("mgr"));
		eHiredate.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
		eSal.setCellValueFactory(new PropertyValueFactory<>("sal"));
		eComm.setCellValueFactory(new PropertyValueFactory<>("comm"));
		eDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
		
		eEmp.setItems(oblist);
	}

}
