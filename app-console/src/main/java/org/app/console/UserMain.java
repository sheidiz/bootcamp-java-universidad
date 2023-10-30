package org.app.console;

import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.bootcamp.User;

public class UserMain 
{
    public static void main( String[] args )
    {
    	UserService service = (UserService) ServiceLocator.getService(UserService.class);    	
    	
//    	System.out.println(service.buscarTodos());
    	/*User user6 =service.buscarPoId(6L);*/

    	//service.eliminarPorId(7L);
    	/*
    	User user = service.buscarPorId(6L);
    	
    	System.out.println(user6);
    	System.out.println(user);
    	*/
//    	User user = service.buscarPorId(1L);
//    	
//    	System.out.println(user);
    	User newUser = new User("1", "editado");
    	service.actualizar(new User(1l,"user","editado"));
//
//    	System.out.println(newUser.getId()); //se lo setea la implementacion de CrudBase!
    }
}