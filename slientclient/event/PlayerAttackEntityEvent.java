package slientclient.event;

import slientclient.event.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerAttackEntityEvent
  extends EventCancellable
{
  private final EntityPlayer sourceEntity;
  private Entity targetEntity;
  
  public PlayerAttackEntityEvent(EntityPlayer sourceEntity, Entity targetEntity)
  {
    this.sourceEntity = sourceEntity;
    this.targetEntity = targetEntity;
  }
  
  public EntityPlayer getSource()
  {
    return this.sourceEntity;
  }
  
  public Entity getTarget()
  {
    return this.targetEntity;
  }
  
  public void setTarget(Entity targetEntity)
  {
    this.targetEntity = targetEntity;
  }
}
