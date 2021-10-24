package slientclient.event;

import java.util.ArrayList;

import slientclient.*;
import net.minecraft.*;

public interface LeftClickListener extends Event
{
	public void onLeftClick(LeftClickEvent event);
	
	public static class LeftClickEvent
	{
		public void fire(ArrayList<LeftClickListener> listeners)
		{
			for(LeftClickListener listener : listeners)
			{
				listener.onLeftClick(this);
				
				if(isCancelled())
					break;
			}
		}
		
		private boolean isCancelled() {
			// TODO Auto-generated method stub
			return false;
		}

		public Class<LeftClickListener> getListenerType()
		{
			return LeftClickListener.class;
		}
	}
}
