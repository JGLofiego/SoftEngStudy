
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String email;
	private String nome;
	private List<Blog> meusBlogs = new ArrayList<Blog>();
	
	public String getEmail() {
		return this.email;
	}
}
