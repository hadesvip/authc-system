package com.cn.furious.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.cn.furious.model.User;
import com.cn.furious.service.RegistService;
import com.cn.furious.service.UserService;

/**
 * @author szj
 * filter-->securityM-->authenticator/authorizer...--->realms
 * realms return 授权信息（SimpleAuthenticationInfo）
 * authenticator对其进行验证
 */
public class DbRealm extends AuthorizingRealm {


	@Autowired
	private UserService userService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		User user = new User();
		user.setUsername(username);
		if (!StringUtils.isEmpty(username)) {
			user = userService.query(user);
			if (user != null) {
				Subject subject = SecurityUtils.getSubject();
				subject.getSession().setAttribute("user", user);
				// 参数1：principal主体,可以subject.getPrincipal取出来
				// 参数2:查到的凭证（可以加上盐）
				// 参数3:当有多个realm时，使用过一个就记录一个，pop出队列
				// TODO 未加密
				return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
				//返回后根据login（token）来验证
			}
		}
		return null;
	}
//
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
