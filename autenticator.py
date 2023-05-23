from flask import Flask, request, jsonify

app = Flask(__name__)

# Cria um dicionário de usuários com nome de usuário e senha
users = {'user1': 'password1', 'user2': 'password2'}

# Cria uma rota para o endpoint '/login'
@app.route('/login', methods=['POST'])
def login():
    # Recebe as credenciais de login do usuário
    username = request.json['username']
    password = request.json['password']

    # Verifica se as credenciais estão corretas
    if username in users and users[username] == password:
        return jsonify({'message': 'Login realizado com sucesso!'})
    else:
        return jsonify({'message': 'Nome de usuário ou senha incorretos.'}), 401

if __name__ == '__main__':
    app.run(debug=True)
