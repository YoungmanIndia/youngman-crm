package com.youngman.youngman.services;

import com.youngman.model.business.constants.Constants;
import com.youngman.model.business.services.user.UserService;
import com.youngman.model.enums.GroupType;
import com.youngman.model.model.common.Group;
import com.youngman.model.model.common.Permission;
import com.youngman.youngman.admin.WebUserServices;
import com.youngman.youngman.security.SecurityDataAccessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author casams1
 *         http://stackoverflow.com/questions/5105776/spring-security-with
 *         -custom-user-details
 */
@Service("userDetailsService")
public class UserServiceImpl implements WebUserServices {


	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private static final String DEFAULT_INITIAL_PASSWORD = "password";

	@Inject
	private UserService userService;

	@Inject
	private PermissionService permissionService;

	@Inject GroupService groupService;

	@Inject
	@Named("passwordEncoder")
	private PasswordEncoder passwordEncoder;


	public final static String ROLE_PREFIX = "ROLE_";



	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {

		com.youngman.model.model.crm.User user = null;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		try {

			user = userService.getByUserName(userName);

			if(user==null) {
				return null;
			}

			GrantedAuthority role = new SimpleGrantedAuthority(ROLE_PREFIX + Constants.PERMISSION_AUTHENTICATED);//required to login
			authorities.add(role);

			List<Integer> groupsId = new ArrayList<Integer>();
			List<Group> groups = user.getGroups();
			for(Group group : groups) {


				groupsId.add(group.getId());

			}

			List<Permission> permissions = permissionService.getPermissions(groupsId);
			for(Permission permission : permissions) {
				GrantedAuthority auth = new SimpleGrantedAuthority(ROLE_PREFIX + permission.getPermissionName());
				authorities.add(auth);
			}

		} catch (Exception e) {
			LOGGER.error("Exception while querrying user",e);
			throw new SecurityDataAccessException("Exception while querrying user",e);
		}





		User secUser = new User(userName, user.getPassword(), user.isActive(), true,
				true, true, authorities);
		return secUser;
	}


	public void createDefaultAdmin() throws Exception {

		String password = passwordEncoder.encode(DEFAULT_INITIAL_PASSWORD);

		List<Group> groups = groupService.listGroup(GroupType.ADMIN);

		//creation of the super admin admin:password)
		com.youngman.model.model.crm.User user = new com.youngman.model.model.crm.User("admin@shopizer.com",password,"admin@shopizer.com");
		user.setName("Administrator");

		for(Group group : groups) {
			if(group.getGroupName().equals(Constants.GROUP_SUPERADMIN) || group.getGroupName().equals(Constants.GROUP_ADMIN)) {
				user.getGroups().add(group);
			}
		}

		userService.saveOrUpdate(user);


	}

}
