package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.ServerSocket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void Task6Test1() throws IOException {
        Task6.searchSockets();
        ServerSocket socket = null;
        for (int i = 0; i < 49151; ++i) {
            if (Task6.isPortFree[i]) {
                socket = null;
                try {
                    socket = new ServerSocket(i);
                } catch (IOException exc) {
                    assertThat(true).isFalse();
                }
                if(socket!=null)socket.close();
            }
        }
    }
}
