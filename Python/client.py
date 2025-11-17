import socket

HOST = '127.0.0.1'
PORT = 5000

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client_socket.connect((HOST, PORT))
print(f"Conectado ao servidor. Digite mensagens.")

while True:
    msg = input("\u001b[32m(Cliente): ")
    if msg.lower() == 'out':
        break
    
    client_socket.sendall(msg.encode()) 

    # Recebe resposta
    data = client_socket.recv(1024)
    print(f"\u001b[31mServidor: {data.decode()}")

client_socket.close()