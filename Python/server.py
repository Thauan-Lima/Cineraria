import socket

HOST = '127.0.0.1'
PORT = 5000

# Criando o socket
# AF = adress family; INET = ipv4; SOCK_STREAM = TCP
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Ligando o socket ao IP e porta
server_socket.bind((HOST, PORT))

# Deixando o servidor pronto para ouvir
server_socket.listen(1)
print(f"Server aguardando conectar em {HOST}:{PORT}")

# Aceita a primeira conexão que chegar
conn, addr = server_socket.accept()
print(f"Conectado por {addr}")

while True:
    data = conn.recv(1024) # Limita o número de bytes para 1024
    if not data:
        print("\u001b[0mCliente desconectado")
        break
    print(f"\u001b[32mCliente: {data.decode()}")

    # Enviando a resposta
    msg = input("\u001b[31m(Servidor): ")
    conn.sendall(msg.encode())
