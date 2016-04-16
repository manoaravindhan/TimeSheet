/**
 * 
 */
package com.timesheet;

/**
 * @author Mano
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserData {
	@SuppressWarnings("unchecked")
	public List<UserBean> getAllUserBeans(){
	      List<UserBean> UserBeanList = null;
	      try {
	         File file = new File("UserBeans.dat");
	         if (!file.exists()) {
	            UserBean UserBean = new UserBean(1, "Mano", "Jobless");
	            UserBeanList = new ArrayList<UserBean>();
	            UserBeanList.add(UserBean);
	            saveUserBeanList(UserBeanList);		
	         }
	         else{
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            UserBeanList = (List<UserBean>) ois.readObject();
	            ois.close();
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }		
	      return UserBeanList;
	   }

	   private void saveUserBeanList(List<UserBean> UserBeanList){
	      try {
	         File file = new File("UserBeans.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(UserBeanList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
}
