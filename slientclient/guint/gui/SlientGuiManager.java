/*
 
 */
package slientclient.guint.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.darkstorm.minecraft.gui.AbstractGuiManager;
import org.darkstorm.minecraft.gui.component.BoundedRangeComponent.ValueDisplay;
import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.ComboBox;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.component.Slider;
import org.darkstorm.minecraft.gui.component.basic.BasicButton;
import org.darkstorm.minecraft.gui.component.basic.BasicCheckButton;
import org.darkstorm.minecraft.gui.component.basic.BasicComboBox;
import org.darkstorm.minecraft.gui.component.basic.BasicFrame;
import org.darkstorm.minecraft.gui.component.basic.BasicLabel;
import org.darkstorm.minecraft.gui.component.basic.BasicProgressBar;
import org.darkstorm.minecraft.gui.component.basic.BasicSlider;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager;
import org.darkstorm.minecraft.gui.layout.GridLayoutManager.HorizontalGridConstraint;
import org.darkstorm.minecraft.gui.listener.ButtonListener;
import org.darkstorm.minecraft.gui.listener.ComboBoxListener;
import org.darkstorm.minecraft.gui.theme.Theme;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

import net.minecraft.client.Minecraft;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.mods.Module;


public final class SlientGuiManager extends AbstractGuiManager {
	private class ModuleFrame extends BasicFrame {
		private ModuleFrame() {
		}

		private ModuleFrame(String title) {
			super(title);
		}
	}

	private final AtomicBoolean setup;

	public SlientGuiManager() {
		setup = new AtomicBoolean();
	}

	@Override
	public void setup() {
		final Map<Category, ModuleFrame> categoryFrames = new HashMap<Category, ModuleFrame>();
		for(Module m: Slient.getModules()){
			ModuleFrame frame = categoryFrames.get(m.getCategory());
			if(frame == null){
				String name = m.getCategory().toString().toLowerCase();
				name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
				frame = new ModuleFrame(name);
				frame.setTheme(new SimpleTheme());
				frame.setLayoutManager(new GridLayoutManager(2, 0));
				frame.setVisible(true);
				frame.setClosable(false);
				frame.setMinimized(true);
				
				addFrame(frame);
				categoryFrames.put(m.getCategory(), frame);
			}
			frame.add(new BasicLabel(m.getName()));
			final Module updateModule = m;
			Button button = new BasicButton(m.isToggled() ? "Disable" : "Enable"){
				@Override
				public void update(){
					setText(updateModule.isToggled() ? "Disable" : "Enable");
				}
			};
			button.addButtonListener(new ButtonListener(){
				@Override
				public void onButtonPress(Button button){
					updateModule.toggle();
					button.setText(updateModule.isToggled() ? "Disable" : "Enable");
				}
			});
			frame.add(button, HorizontalGridConstraint.RIGHT);
		}

		// Optional equal sizing and auto-positioning
		resizeComponents();
		Minecraft minecraft = Minecraft.getMinecraft();
		Dimension maxSize = recalculateSizes();
		int offsetX = 5, offsetY = 5;
		int scale = minecraft.gameSettings.guiScale;
		if(scale == 0)
			scale = 1000;
		int scaleFactor = 0;
		while(scaleFactor < scale && minecraft.displayWidth / (scaleFactor + 1) >= 320 && minecraft.displayHeight / (scaleFactor + 1) >= 240)
			scaleFactor++;
		for(Frame frame : getFrames()) {
			frame.setX(offsetX);
			frame.setY(offsetY);
			offsetX += maxSize.width + 5;
			if(offsetX + maxSize.width + 5 > minecraft.displayWidth / scaleFactor) {
				offsetX = 5;
				offsetY += maxSize.height + 5;
			}
		}
	}

	private void createTestFrame() {
		Theme theme = getTheme();
		Frame testFrame = new BasicFrame("Frame");
		testFrame.setTheme(theme);

		testFrame.add(new BasicLabel("TEST LOL"));
		testFrame.add(new BasicLabel("TEST 23423"));
		testFrame.add(new BasicLabel("TE123123123ST LOL"));
		testFrame.add(new BasicLabel("31243 LO3242L432"));
		BasicButton testButton = new BasicButton("Duplicate this frame!");
		testButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				createTestFrame();
			}
		});
		testFrame.add(new BasicCheckButton("This is a checkbox"));
		testFrame.add(testButton);
		ComboBox comboBox = new BasicComboBox("Simple theme", "Other theme", "Other theme 2");
		comboBox.addComboBoxListener(new ComboBoxListener() {

			@Override
			public void onComboBoxSelectionChanged(ComboBox comboBox) {
				Theme theme;
				switch(comboBox.getSelectedIndex()) {
				case 0:
					theme = new SimpleTheme();
					break;
				case 1:
					// Some other theme
					// break;
				case 2:
					// Another theme
					// break;
				default:
					return;
				}
				setTheme(theme);
			}
		});
		testFrame.add(comboBox);
		Slider slider = new BasicSlider("Test");
		slider.setContentSuffix("things");
		slider.setValueDisplay(ValueDisplay.INTEGER);
		testFrame.add(slider);
		testFrame.add(new BasicProgressBar(50, 0, 100, 1, ValueDisplay.PERCENTAGE));

		testFrame.setX(50);
		testFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(testFrame).getDefaultSize(testFrame);
		testFrame.setWidth(defaultDimension.width);
		testFrame.setHeight(defaultDimension.height);
		testFrame.layoutChildren();
		testFrame.setVisible(true);
		testFrame.setMinimized(true);
		addFrame(testFrame);
	}

	@Override
	protected void resizeComponents() {
		Theme theme = getTheme();
		Frame[] frames = getFrames();
		Button enable = new BasicButton("Enable");
		Button disable = new BasicButton("Disable");
		Dimension enableSize = theme.getUIForComponent(enable).getDefaultSize(enable);
		Dimension disableSize = theme.getUIForComponent(disable).getDefaultSize(disable);
		int buttonWidth = Math.max(enableSize.width, disableSize.width);
		int buttonHeight = Math.max(enableSize.height, disableSize.height);
		for(Frame frame : frames) {
			if(frame instanceof ModuleFrame) {
				for(Component component : frame.getChildren()) {
					if(component instanceof Button) {
						component.setWidth(buttonWidth);
						component.setHeight(buttonHeight);
					}
				}
			}
		}
		recalculateSizes();
	}

	private Dimension recalculateSizes() {
		Frame[] frames = getFrames();
		int maxWidth = 0, maxHeight = 0;
		for(Frame frame : frames) {
			Dimension defaultDimension = frame.getTheme().getUIForComponent(frame).getDefaultSize(frame);
			maxWidth = Math.max(maxWidth, defaultDimension.width);
			frame.setHeight(defaultDimension.height);
			if(frame.isMinimized()) {
				for(Rectangle area : frame.getTheme().getUIForComponent(frame).getInteractableRegions(frame))
					maxHeight = Math.max(maxHeight, area.height);
			} else
				maxHeight = Math.max(maxHeight, defaultDimension.height);
		}
		for(Frame frame : frames) {
			frame.setWidth(maxWidth);
			frame.layoutChildren();
		}
		return new Dimension(maxWidth, maxHeight);
	}

}
