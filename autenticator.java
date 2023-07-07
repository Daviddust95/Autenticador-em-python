import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class AuthApplication {

    // Cria um mapa de usuários com nome de usuário e senha
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // Verifica se as credenciais estão corretas
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nome de usuário ou senha incorretos.");
        }
    }

    static {
        // Popula o mapa de usuários com exemplos
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    static class LoginForm {
        private String username;
        private String password;

        // Getters e Setters

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
