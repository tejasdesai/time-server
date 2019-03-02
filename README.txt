A time server is a server that reads the actual time from a reference clock and distribute this information to its clients.

1. Used the TCP protocol.

2. Server is a multithreaded one. For each client connection request, there is a new thread. 

3. The time information is not back to the client, just displayed on the server. 