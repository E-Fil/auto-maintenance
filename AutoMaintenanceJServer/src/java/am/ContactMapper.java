package am;

import org.apache.ibatis.annotations.Param;
import am.Contact;

import java.util.List;

public interface ContactMapper {

	Integer insert(Contact contact);

	List<Contact> selectAll();

	Contact select(Integer id);

	Integer update(Contact contact);

	Integer delete(Integer id);
	
}
