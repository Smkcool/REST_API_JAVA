package main.java.com.user.app.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.user.app.model.UserVO;


public class UserUtil {
	static List<UserVO> userList = new ArrayList<UserVO>();
	static int userId = 1;
	public static List<UserVO> getUsers() {
		return userList;
	}

	public static UserVO getUser(int id) {
		for (UserVO userVo : userList) {
			if (userVo.getId() == id) {
				return userVo;
			}
		}
		return new UserVO();
	}

	public static void addUser(UserVO userVO) {
		userVO.setId(userId++);
		userList.add(userVO);
	}

	public static void updateUser(UserVO user) {
		for (UserVO userVo : userList) {
			if (userVo.getId() == user.getId()) {
				userVo.setEmail(user.getEmail());
				userVo.setName(user.getName());
				userVo.setProfession(user.getProfession());
			}
		}
	}

	public static void deleteUser(int id) {
		Iterator<UserVO> itr = userList.iterator();

		while (itr.hasNext()) {
			UserVO userVo = itr.next();
			if (userVo.getId() == id) {
				itr.remove();
			}
		}
	}
}