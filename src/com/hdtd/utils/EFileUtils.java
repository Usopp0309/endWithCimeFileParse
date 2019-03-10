package com.hdtd.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.hdtd.dao.BaseDao;
import com.hdtd.dao.BaseDaoImpl;
import com.hdtd.dao.BaseDaoImplTWO;
import com.hdtd.domain.Aclinedot;
import com.hdtd.domain.Aclinesegment;
import com.hdtd.domain.Aclinesegmentpw;
import com.hdtd.domain.Basevoltage;
import com.hdtd.domain.Breaker;
import com.hdtd.domain.Breakerpw;
import com.hdtd.domain.Busbarsection;
import com.hdtd.domain.Busbarsectionpw;
import com.hdtd.domain.Capacitorpw;
import com.hdtd.domain.Compositeswitchpw;
import com.hdtd.domain.Controlarea;
import com.hdtd.domain.Dcfilter;
import com.hdtd.domain.Dclinedot;
import com.hdtd.domain.Dclinesegment;
import com.hdtd.domain.Dcsmoothingreactor;
import com.hdtd.domain.Disconnector;
import com.hdtd.domain.Disconnectorpw;
import com.hdtd.domain.Dlscddmonthpaper;
import com.hdtd.domain.Energyconsumerpw;
import com.hdtd.domain.Energystorageequipmentpw;
import com.hdtd.domain.Faultindicatorpw;
import com.hdtd.domain.Feederpw;
import com.hdtd.domain.Fuse;
import com.hdtd.domain.Fusepw;
import com.hdtd.domain.Generatorpw;
import com.hdtd.domain.Grounddisconnector;
import com.hdtd.domain.Grounddisconnectorpw;
import com.hdtd.domain.Load;
import com.hdtd.domain.Loadbreakswitch;
import com.hdtd.domain.Loadbreakswitchpw;
import com.hdtd.domain.Polepw;
import com.hdtd.domain.Powertransformer;
import com.hdtd.domain.Powertransformerpw;
import com.hdtd.domain.Reactorpw;
import com.hdtd.domain.Rectifierinverter;
import com.hdtd.domain.Seriescompensator;
import com.hdtd.domain.Shuntcompensator;
import com.hdtd.domain.Substation;
import com.hdtd.domain.Substationpw;
import com.hdtd.domain.Synchronousmachine;
import com.hdtd.domain.Tapchangertype;
import com.hdtd.domain.Transformerwinding;
import com.hdtd.domain.Tvpw;
import com.hdtd.domain.Voltagelevel;
import com.hdtd.domain.WeatherWarning;
import com.hdtd.mapper.WeatherWarningMapper;

public class EFileUtils {
	
	
	
	/**
	 * 根据字段行与数据行获取map  key为属性，value为值，共beanutils使用
	 */
	public static Map<String, Object> getPojoMap(String fieldLine,String dataLine){
		//字段行                                                                                                            //split("\t");
		String[] fieldSplit = fieldLine.replace("@", "").split("\t");
		
		//数据行
//		dataLine = dataLine.replace("#\t", "");
		dataLine = dataLine.substring(2);
		                                 //\t
		String[] dataSplit = dataLine.split("\t");
		
		Map<String, Object> map = new HashMap<String,Object>();
		for (int i = 0; i < fieldSplit.length; i++) {
			fieldSplit[i] = EFileUtils.firstChar2Lower(fieldSplit[i]);
			if(dataSplit[i].toLowerCase().equals("null")){		//null显示为字符串还是null空
				dataSplit[i] = null;
			}
			map.put(fieldSplit[i], dataSplit[i]);
		}
//		System.out.println(map);
		
		return map;
	}
	
	
	/**
	 * 根据类名和map获取带有属性的对象
	 */
	public static <T> T getPojoFromMap(Map<String, Object> map,String classType) throws ClassNotFoundException, Exception {
		String className = "com.hdtd.domain."+classType;
		
		Class clazz = Class.forName(className);
		System.out.println("类加载异常1");
		Object obj = clazz.newInstance();
System.out.println("类加载异常2");		
		BeanUtils.populate(obj, map);
//		System.out.println(obj);
		return (T)obj;
		
	}
	
	/**
	 * 根据字符串获取类型名称
	 * 如：<BaseVoltage::承德>
	 */
	public static String getClassName(String dataLine){
		String className = dataLine.replace("<", "").split("::")[0];
		if(dataLine.contains("配网")){
			className += "PW";
		}
//		System.out.println(className);
		return className;
	}
	
	/**
	 * 首字母小写
	 */
	public static String firstChar2Lower(String data){
		if(data == null || data.length()<1){
			return "";
		}
		
		String start = String.valueOf(data.charAt(0)).toLowerCase();
		String end = "";
		if(data.length()>1){
			end = data.substring(1);
		}
		data = start + end;
		return data;
	}
	
	public static BaseDao getBaseDao(String className){
		BaseDao dao = null;
		switch (className) {
//		case "BaseVoltage":
//			dao = new BaseDaoImpl<Basevoltage>();
////			new BaseDao<BaseVoltage>().saveOrUpdate(context,obj);
//			break;
//		case "ControlArea":
//			dao = new BaseDaoImpl<Controlarea>();
//			break;
//		case "Substation":
//			dao = new BaseDaoImpl<Substation>();
//			break;
		case "BaseVoltage":
			dao = new BaseDaoImpl<Basevoltage>();
			break;
		case "ControlArea":
			dao = new BaseDaoImpl<Controlarea>();
			break;
		case "Substation":
			dao = new BaseDaoImpl<Substation>();
			break;
		case "VoltageLevel":
			dao = new BaseDaoImpl<Voltagelevel>();
			break;
		case "Breaker":
			dao = new BaseDaoImpl<Breaker>();
			break;
		case "LoadBreakSwitch":
			dao = new BaseDaoImpl<Loadbreakswitch>();
			break;
		case "Fuse":
			dao = new BaseDaoImpl<Fuse>();
			break;
		case "Disconnector":
			dao = new BaseDaoImpl<Disconnector>();
			break;
		case "GroundDisconnector":
			dao = new BaseDaoImpl<Grounddisconnector>();
			break;
		case "BusbarSection":
			dao = new BaseDaoImpl<Busbarsection>();
			break;
		case "SynchronousMachine":
			dao = new BaseDaoImpl<Synchronousmachine>();
			break;
		case "ACLineSegment":
			dao = new BaseDaoImpl<Aclinesegment>();
			break;
		case "ACLineDot":
			dao = new BaseDaoImpl<Aclinedot>();
			break;
		case "DCLineSegment":
			dao = new BaseDaoImpl<Dclinesegment>();
			break;
		case "DCLineDot":
			dao = new BaseDaoImpl<Dclinedot>();
			break;
		case "Dcsmoothingreactor":
			dao = new BaseDaoImpl<Dcsmoothingreactor>();
			break;
		case "Dcfilter":
			dao = new BaseDaoImpl<Dcfilter>();
			break;
		case "RectifierInverter":
			dao = new BaseDaoImpl<Rectifierinverter>();
			break;
		case "Load":
			dao = new BaseDaoImpl<Load>();
			break;
		case "PowerTransformer":
			dao = new BaseDaoImpl<Powertransformer>();
			break;
		case "TransformerWinding":
			dao = new BaseDaoImpl<Transformerwinding>();
			break;
		case "TapChangerType":
			dao = new BaseDaoImpl<Tapchangertype>();
			break;
		case "ShuntCompensator":
			dao = new BaseDaoImpl<Shuntcompensator>();
			break;
		case "SeriesCompensator":
			dao = new BaseDaoImpl<Seriescompensator>();
			break;
		case "FeederPW":
			dao = new BaseDaoImpl<Feederpw>();
			break;
		case "SubstationPW":
			dao = new BaseDaoImpl<Substationpw>();
			break;
		case "CompositeSwitchPW":
			dao = new BaseDaoImpl<Compositeswitchpw>();
			break;
		case "BreakerPW":
			dao = new BaseDaoImpl<Breakerpw>();
			break;
		case "LoadBreakSwitchPW":
			dao = new BaseDaoImpl<Loadbreakswitchpw>();
			break;
		case "FusePW":
			dao = new BaseDaoImpl<Fusepw>();
			break;
		case "DisconnectorPW":
			dao = new BaseDaoImpl<Disconnectorpw>();
			break;
		case "GroundDisconnectorPW":
			dao = new BaseDaoImpl<Grounddisconnectorpw>();
			break;
		case "BusbarSectionPW":
			dao = new BaseDaoImpl<Busbarsectionpw>();
			break;
		case "GeneratorPW":
			dao = new BaseDaoImpl<Generatorpw>();
			break;
		case "EnergyStorageEquipmentPW":
			dao = new BaseDaoImpl<Energystorageequipmentpw>();
			break;
		case "ACLineSegmentPW":
			dao = new BaseDaoImpl<Aclinesegmentpw>();
			break;
		case "EnergyConsumerPW":
			dao = new BaseDaoImpl<Energyconsumerpw>();
			break;
		case "PowerTransformerPW":
			dao = new BaseDaoImpl<Powertransformerpw>();
			break;
		case "ReactorPW":
			dao = new BaseDaoImpl<Reactorpw>();
			break;
		case "CapacitorPW":
			dao = new BaseDaoImpl<Capacitorpw>();
			break;
		case "FaultIndicatorPW":
			dao = new BaseDaoImpl<Faultindicatorpw>();
			break;
		case "TVPW":
			dao = new BaseDaoImpl<Tvpw>();
			break;
		case "PolePW":
			dao = new BaseDaoImpl<Polepw>();
		case "DlscddMonthPaper":
			dao=new BaseDaoImplTWO<Dlscddmonthpaper>();
			break;
		/*case "WeatherWarning":
			dao=new BaseDaoImplTWO<WeatherWarning>();*/
		default:
			break;
		}
		return dao;
		
	}
	
	
	public static String getName(String name){
		String s2 = name.substring(1).toLowerCase();
		String n = name.charAt(0)+s2;
		return n;
	}
}
