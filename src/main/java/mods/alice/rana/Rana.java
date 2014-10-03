package mods.alice.rana;

import java.util.Collections;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
	modid = "ranamob",
	name="Rana",
	version = "1.8",
	dependencies = "required-after:Forge@[10.13.0.1180,)",
	guiFactory = "mods.alice.rana.client.gui.ConfigGuiFactory"
)
public final class Rana
{
	@Mod.Instance("ranamob")
	public static Rana INSTANCE;

	@Mod.Metadata("ranamob")
	public ModMetadata meta;

	@SidedProxy(clientSide = "mods.alice.rana.client.ClientProxy", serverSide = "mods.alice.rana.CommonProxy")
	public static CommonProxy PROXY;

	private ModConfig config;

	@Mod.EventHandler
	public void forgePreInitialization(FMLPreInitializationEvent event)
	{
		config = new ModConfig(event.getSuggestedConfigurationFile());
		config.syncConfig();

		this.meta.modId = "ranamob";
		this.meta.name = "Rana/ラナさん";
		this.meta.description = "Add `Rana' mob.\nラナさんを追加します。";
		this.meta.url = "http://a1lic.net/";
		//this.meta.updateUrl = "http://a1lic.net/";
		//this.meta.logoFile = "";
		this.meta.version = "1.8";
		this.meta.authorList.add("alice");
		this.meta.credits = "alice";
		this.meta.parent = "Minecraft";
		this.meta.screenshots = new String[0];
		//this.meta.parentMod;
		//this.meta.childMods;
		this.meta.useDependencyInformation = false;
		this.meta.requiredMods = Collections.emptySet();
		this.meta.dependencies = Collections.emptyList();
		this.meta.dependants = Collections.emptyList();

		// falseにしないとMod listで情報が出ない。
		this.meta.autogenerated = false;
	}

	@Mod.EventHandler
	public void forgeInitialization(FMLInitializationEvent event)
	{
		Rana.PROXY.initialize();
	}

	public ModConfig getConfig()
	{
		return this.config;
	}

	public static CommonProxy getProxy()
	{
		return Rana.PROXY;
	}
}
