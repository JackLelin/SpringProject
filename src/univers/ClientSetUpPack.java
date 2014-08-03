package univers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientSetUpPack implements Serializable
{
	private HashMap<Integer,String> IconMap = new HashMap<Integer,String>();
	private HashMap<Integer,String> NameMap = new HashMap<Integer,String>();
	
	public ClientSetUpPack(HashMap<Integer,String> IconMap,HashMap<Integer,String> NameMap)
	{
		this.setIconMap(IconMap);
		this.setNameMap(NameMap);
	}
	
	public String toString()
	{
		return "ClientSetUpPack";
	}

	public HashMap<Integer,String> getNameMap() {
		return NameMap;
	}

	public void setNameMap(HashMap<Integer,String> nameMap) {
		NameMap = nameMap;
	}

	public HashMap<Integer,String> getIconMap() {
		return IconMap;
	}

	public void setIconMap(HashMap<Integer,String> iconMap) {
		IconMap = iconMap;
	}

}
