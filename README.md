# Autenticador-em-python

aplicação Flask que possui uma rota '/login'. Na rota, você recebe as credenciais de login do usuário por meio de uma requisição POST e verifica se as informações estão corretas em um dicionário chamado users. Se as credenciais forem válidas, retorna uma mensagem de sucesso. Caso contrário, retorna uma mensagem de erro.

Será necessário instalar o flask para execução do programa, digite no terminal ou cmd:

pip install flask

Após instação do flask, é possível executar o arquivo autenticador.py no servidor flask local. Abra o prompt de comando do Windows ou terminal do linux e use o seguinte comando curl para enviar a solicitação POST:

curl -X POST -H "Content-Type: application/json" -d "{\"username\":\"user1\", \"password\":\"password1\"}" http://localhost:5000/login

Caso os dados estejam corretos, você receberá uma respota "Login realizado com sucesso".
