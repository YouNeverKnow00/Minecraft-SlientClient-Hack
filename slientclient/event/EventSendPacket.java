package slientclient.event;

import slientclient.*;
import net.minecraft.*;
import net.minecraft.network.Packet;

public class EventSendPacket implements Event
{
    private Packet packet;

    public EventSendPacket(Packet packet) {
        packet = null;
        setPacket(packet);
    }

    public Packet getPacket() {
        return packet;
    }
    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
