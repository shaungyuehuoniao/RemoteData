package DataAn.fileSystem.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import DataAn.common.utils.DateUtil;
import DataAn.fileSystem.option.FlyWheelDataType;

import com.alibaba.fastjson.JSON;

public class CSVTest {

	@Test
	public void readTitle() throws Exception{
		File file = new File("C:\\j9-02--2016-02-01.csv");
		InputStream in = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(in, "gb2312");
		BufferedReader reader = new BufferedReader(inputStreamReader);// 换成你的文件名
		String line1 = reader.readLine();// 第一行信息，为标题信息，不用,如果需要，注释掉
		System.out.println(line1);
//		String[] strs = line1.split(",");
//		for (String string : strs) {
//			System.out.println(string);
//		}
	}
	@Test
	public void parseString(){
		//数管分系统
		String str1 = "F0W53_54:滚动陀螺角速度(00131),F0W55_56:俯仰陀螺角速度(00133),F0W57_58:偏航陀螺角速度(00135),F0W59_60:滚动陀螺角(00137),F0W61_62:俯仰陀螺角(00139),F0W63_64:偏航陀螺角(00141),F1W53_54:地平仪滚动姿态(00132),F1W55_56:地平仪俯仰姿态(00134),F1W57_58:可变参数13(00136),F1W59_60:可变参数14(00138),F1W61_62:可变参数15(00140),F1W63_64:程序运行状态(00142),F1W63B0:机动程控标志(01162),F1W63B1:相机数据可用标志(01163),F1W63B2:GPS数据可用标志(01164),F1W63B3:应急工作模式标志(01165),F1W63B4:太阳电池阵-Y锁定标志(01166),F1W63B5:太阳电池阵+Y锁定标志(01167),F1W63B6:故障启用ROM(01168),F1W63B7:调试陷入标志(01169),F1W64B0:飞程序故障标志(01170),F1W64B1:浮点下溢故障标志(01171),F1W64B2:浮点上溢故障标志(01172),F1W64B3:定点溢出故障标志(01173),F1W64B4:机器错故障标志(01174),F1W64B5:看门狗故障标志(01175),F1W64B6:计算机正常启动标志(01176),F1W64B7:(01177),F0W65_66:帆板A模拟太阳角(00143),F0W67_68:帆板B模拟太阳角(00151),F0W69_70:帆板A模拟信号1(00156),F0W71_72:帆板A模拟信号2(00164),F0W73_74:帆板B模拟信号1(00169),F0W73_76:1A星敏感器测量的q2(00174),F0W75_76:帆板B模拟信号2(00177),F0W77_80:近地点幅角与真近点角之和U(00185),F0W81_84:对应当前星敏感器取数时刻的轨道幅角(00194),F0W85_88:平根E(00203),F0W89_92:平根w(00212),F0W93_96:平根M(00220),F0W97_100:平根升交点赤经(00227),F0W101_102:平根T日期(00242),F0W103_106:平根T时间(00243),F0W115:GPS接收机工作状态(00264),F0W116:通道最高信噪比(00266),F0W117:时间周数(00267),F0W118:时间高字节(00268),F0W107_110:平根轨道倾角i(01021),F0W111_112:间接指令计数(01029),F0W113_114:帧同步字(01036),F1W65_66:X轴磁强计磁场(00144),F1W67_68:Y轴磁强计磁场(00152),F1W69_70:Z轴磁强计磁场(00157),F1W71_72:X轴地磁场(00165),F1W73_74:Y轴地磁场(00170),F1W75_76:Z轴地磁场(00178),F1W77_78:X轴磁电流(00182),F1W79_80:Y轴磁电流(00190),F1W81_82:Z轴磁电流(00193),F1W83_84:太敏信号1(00201),F1W85_86:太敏信号2（8路角计）(00202),F1W87_88:滚动地平仪遇太阳标志(00210),F1W89_90:星体A模拟太阳角(00211),F1W91_92:星体B模拟太阳角(00219),F1W113:GPS时间次中字节(00260),F1W114:GPS时间低字节(00262),F1W107_110:摄像时间(01022),F1W111_112:传送指令计数(01030),F1W115_118:GPS X位置坐标(01046),F6W93_96:飞轮转速控制X(02350),F1W97_100:飞轮转速控制Y(02351),F1W101_104:飞轮转速控制Z(02352),F1W105_106:软件重注标志(02353),F6W83B0:(02385),F1W83B1:(02386),F1W83B2:(02387),F1W83B3:(02388),F1W83B4:(02389),F1W83B5:(02390),F1W83B6:xt角计B遇太阳标志(02391),F1W83B7:xt角计A遇太阳标志(02392),F1W84B0:角计B遇太阳标志(02393),F1W84B1:角计A遇太阳标志(02394),F1W84B2:Ⅵ象限遇太阳标志(02395),F1W84B3:Ⅴ象限遇太阳标志(02396),F1W84B4:Ⅳ象限遇太阳标志(02397),F1W84B5:Ⅲ象限遇太阳标志(02398),F1W84B6:Ⅱ象限遇太阳标志(02399),F1W84B7:Ⅰ象限遇太阳标志(02400),F2W65_66:x轴陀螺欧拉角速度L(00145),F2W67_68:y轴陀螺欧拉角速度L(00153),F2W69_70:z轴陀螺欧拉角速度L(00158),F2W71_72:-Y电池阵驱动标志(00166),F2W73_74:+Y电池阵驱动标志(00171),W87_88:太阳定向程序流向标志(00179),F2W77_80:1A陀螺X轴欧拉角速度(00183),F2W81_84:1A陀螺Y轴欧拉角速度(00195),F2W85_88:1A陀螺Z轴欧拉角速度(00204),F2W89_92:1B陀螺X轴欧拉角速度(00213),F2W93_96:1B陀螺Y轴欧拉角速度(00221),F2W97_100:1B陀螺Z轴欧拉角速度(00228),F2W109_110:成像1时间长度(01023),F2W111_112:计算机状态标志(01031),F2W113_116:Y位置坐标(01041),F2W117_118:Z位置坐标(01048),F2W111B0: 遥测A/B通道标志(01178),F2W111B1:自动温控标志(01179),F2W111B2:起用校验标志(01180),F2W111B3:软/硬件0.2s计时标志(01181),F2W111B4:A/B机遥测标志(01182),F2W111B5:A/B控制权标志(01183),F2W111B6:温控通道选用A/B通道(01184),F2W111B7: 控制状态标志(01185),F2W112B0:校时标志(01186),F2W112B1:允许在轨编程标志(01187),F2W112B2:RS422通道3正常标志(01188),F2W112B3:RS422通道2正常标志(01189),F2W112B4:RS422通道1正常标志(01190),F2W112B5:GPS通信标志(01191),F2W112B118: A/B机允许注数标志(01192),F2W101_102:星敏感器1A通讯故障标志(02731),F2W107_108:姿态机动时间(02732),F3W119_122:星敏感器3滚动姿态(02734),F3W123_126:星敏感器3俯仰姿态(02735),F3W127_130:星敏感器3偏航姿态(02736),F2W75_76:太阳定向程序流向标志(02793),F3W65_66:滚动右弦宽(00146),F3W67_68:滚动左弦宽(00154),F3W69_70:俯仰右弦宽(00159),F3W71_72:俯仰左弦宽(00167),F3W73_74:滚动俯仰姿态(00172),F3W75_76:俯仰滚动姿态(00180),F3W77_78:星敏自动复位标志(00186),F3W81_82:星体A模拟信号1(00196),F3W85_86:星体B模拟信号1(00205),F3W89_92:罗盘滚动姿态(00214),F3W93_96:罗盘俯仰姿态(00222),F3W97_100:罗盘偏航姿态(00229),F3W101_102:滚动机动加速计时(00239),F3W118:GPS Y速度坐标(00269),F3W109_110:数据1接收时间长度(01024),F3W111_112:GPS与系统钟差值(01032),F3W115_117:GPS X速度坐标(01044),F3W103_104:俯仰机动加速计时(02461),F3W105_106:陀螺故障标志(02466),F3W79_80:EDAC指针(02728),F3W83_84:星体A模拟信号2(02729),F3W87_88:星体B模拟信号2(02730),F3W107B0:首次成像数传发射机及天线状态(02754),F3W107B1:首次成像传输模式(02755),F3W107B2:首次成像记录状态(02756),F3W107B3:首次成像压缩模式(02757),F3W107B4:CCD状态(02758),F3W107B5:相机控制器状态(02759),F3W107B6:综合处理器及压缩状态(02760),F3W107B7:成像程控准禁标志(02761),F3W108B0:二次成像数传发射机及天线状态(02762),F3W108B1:二次成像传输模式(02763),F3W108B2:二次成像记录控制(02764),F3W108B3:二次成像记录状态(02765),F3W108B4:二次成像压缩模式(02766),F3W108B5:压缩监控(02767),F3W108B6:推进主备使用状态(02768),F3W108B7:单双次成像控制(02769),F3W113:Z位置坐标次低字节(02785),F3W114:Z位置坐标最低字节(02786),F3W101_104:双矢量夹角_2k_2_alf(02794),F4W65_68:1A星敏感器测量的q0(00148),F4W69_72:1A星敏感器测量的q1(00161),F4W77_80:1A星敏感器测量的q3(00187),F4W81_84:1B星敏感器测量的q0(00197),F4W85_88:1B星敏感器测量的q1(00206),F4W89_92:1B星敏感器测量的q2(00215),F4W93_96:1B星敏感器测量的q3(00223),F4W118:跟踪导航星最高字节(00270),W65_66:星敏感器2状态字(01017),F4W109_110:姿态机动程控计数(01025),F4W111_112:注数帧计数(01033),F4W113_114:GPS Y速度坐标中字节低字节(01038),F4W115_117:GPS Z速度坐标(01045),W65_66:星敏感器3状态字(02648),W65_66:全姿态飞轮捕获地球滚动姿态累积量(02649),W65_68:飞轮比例项X字节(02650),W65_68:X轴陀螺欧拉角速度L24字节(02651),W67_68:星敏感器1A的数据包ID和长度(02652),W67_68:星敏感器1B的数据包ID和长度(02653),W67_68:全姿态飞轮捕获地球俯仰姿态累积量(02654),W69_72:星敏感器1A的SYNC信号计数(02655),W69_72:星敏感器1B的SYNC信号计数(02656),W69_70:全姿态飞轮捕获地球偏航姿态累积量(02657),W69_72:飞轮积分项X(02658),W69_72:Y轴陀螺欧拉角速度L24(02659),W71_72:稳态全姿态重捕机动到位标志(02660),W73_76:星敏感器1A的最近一次SYNC信号和曝光时刻的差值(02661),W73_74:星体太阳角计A、B严进宽出标志(02662),W73_76:飞轮微分项X(02663),W73_76:Z轴陀螺欧拉角速度L24(02664),W75_76:全姿态初态X陀螺采样积分(02665),W77_80:星敏感器1A姿态包的状态字(02666),W77_80:星敏感器1B姿态包的状态字(02667),W77_80:飞轮比例项Y(02668),W79_80:全姿态初态Z陀螺采样积分(02669),W79_80:T4-1采样角速度Y(02670),W77_78:T4-1采样角速度X(02671),W81_84:1a星敏感器四元数q0(02672),W81_84:1b星敏感器四元数q0(02673),W81_82:星敏感器2曝光时差(02674),W81_82:全姿态X轴控制角速度(02675),W81_84:飞轮积分项Y(02676),W81_82:T4-1采样角速度Z(02677),W83_84:星敏感器3曝光时差(02678),W83_84:全姿态Y轴控制角速度(02679),W83_84:陀螺选用标志(02680),W85_88:1a星敏感器四元数q1(02681),W85_88:1b星敏感器四元数q1(02682),W85_88:星敏感器2星颗数(02683),W85_86:全姿态Z轴控制角速度(02684),W85_88:飞轮微分项Y(02685),W85_86:陀螺信号变换器0V电压(02686),W87_88:陀螺信号变换器2.5V电压(02687),W89_92:1a星敏感器四元数q2(02688),W89_92:1b星敏感器四元数q2(02689),W89_92:星敏感器3测量的q0(02690),W89_90:双矢量滚动姿态(02691),W89_92:飞轮比例项Z(02692),W89_90:TL1A采样角速度X(02693),W91_92:TL1A采样角速度Y(02694),W91_92:俯仰地平仪故障判断结果(02695),W93_96:1a星敏感器四元数q3(02696),W93_96:1b星敏感器四元数q3(02697),W93_96:星敏感器3测量的q1(02698),W93_94:双矢量俯仰姿态(02699),W93_96:飞轮积分项Z(02700),W93_94:TL1A采样角速度Z(02701),W95_96:太阳电池阵驱动器通讯错误标志(02702),W95_96:TL1B采样角速度X(02703),F4W97_100:X轴PID控制力矩(02704),W97_100:星敏感器3测量的q2(02705),W97_98:双矢量偏航姿态(02706),W97_100:飞轮微分项Z(02707),W97_98:TL1B采样角速度Y(02708),W99_100:俯仰通讯错误标志(02709),W99_100:TL1B采样角速度Z(02710),F4W101_104:Y轴PID控制力矩(02711),W101_104:星敏感器3测量的q3(02712),W101_102:接入系统的模拟太阳角计的太阳角滤波值(02713),W101_102:飞轮PID参数使用标志(02714),W101_102:TL2采样角速度X(02715),W103_104:罗盘滚动角速度定点(02716),W103_104:PID角速度X(02717),W103_104:TL2采样角速度Y(02718),F4W105_108:Z轴PID控制力矩(02719),W105_108:星敏感器3星颗数(02720),W105_106:罗盘俯仰角速度定点(02721),W105_106:PID角速度Y(02722),W105_106:TL2采样角速度Z(02723),W107_108:罗盘偏航角速度定点(02724),W107_108:PID角速度Z(02725),W107_108:陀螺信号变换器备用数据(02726),W73_76:星敏感器1A的最近一次SYNC信号和曝光时刻的差值(02727),F5W65_68:飞轮转速Xa(00149),F5W69_72:飞轮转速Ya(00162),F5W73_76:飞轮转速Za(00175),F5W77_80:飞轮转速Xb(00188),F5W81_84:飞轮转速Yb(00198),F5W85_88:飞轮转速Zb(00207),F5W89_92:飞轮指令转速X(00216),F5W93_96:飞轮指令转速Y(00224),F5W97_100:飞轮指令转速Z(00230),F5W101_104:平根Sg(00240),F5W113:跟踪导航星次高字节(00261),F5W114:跟踪导航星次低字节(00263),F5W115:跟踪导航星最低字节(00265),F5W105_108:平根A(01012),F5W109_110:轨控程序确认标志(01026),F5W111_112:偏流角(01034),F5W116_118:TIC计数(01047),F6W65_66:+Y 向控制模式字(00147),F6W67_68:-Y 向控制模式字(00155),F6W69_70:+Y 反馈控制字(00160),F6W71_72:-Y 反馈控制字(00168),F6W73_74:+Y 帆板角度(00173),F6W75_76:-Y 帆板角度(00181),F6W77_78:电池阵驱动器状态字(00184),F6W79_80:电池阵工作标志(00192),W97_100:1A星敏感器滚动姿态(00199),W101_104:1A星敏感器俯仰姿态(00208),W105_108:1A星敏感器偏航姿态(00217),W97_100:1B星敏感器滚动姿态(00225),W101_104:1B星敏感器俯仰姿态(00231),W105_108:1B星敏感器偏航姿态(00241),F6W105_106:星敏1A数据记录指针(01013),F6W107_108:星图数据偏移量(01019),F6W109_110:星敏数据接收长度(01027),F6W111_112:焦平面位置(01035),F6W113_114:可变参数1(01039),F6W115_116:可变参数2(01042),F6W117_118:可变参数3(01049),F6W77B0:+Y机构归零到位信号(02369),F6W77B1:-Y机构归零到位信号(02370),F6W77B2:+Y未检测到零位信号(02371),F6W77B3:-Y未检测到零位信号(02372),F6W77B4:+Y驱动机构主零位信号(02373),F6W77B5:-Y驱动机构主零位信号(02374),F6W77B6:+Y角度信号状态(02375),F6W77B7:-Y角度信号状态(02376),F6W78B0:驱动机构供电状态(02377),F6W78B1:驱动线路工作状态(02378),F6W78B2:上电自检未通过(02379),F6W78B3:连续20秒接收非法指令(02380),F6W78B4:+Y驱动机构备零位信号(02381),F6W78B5:-Y驱动机构备零位信号(02382),F6W78B6:(02383),F6W78B7:(02384),F6W93_96:1B星敏感器滚动姿态(02787),F6W97_100:1B星敏感器俯仰姿态(02788),F6W101_104:1B星敏感器偏航姿态(02789),F6W81_84:1A星敏感器滚动姿态(02790),F6W85_88:1A星敏感器俯仰姿态(02791),F6W89_92:1A星敏感器偏航姿态(02792),F7W65_68:控制用滚动姿态(00150),F7W69_72:控制用俯仰姿态(00163),F7W73_76:控制用偏航姿态(00176),F7W77_78:程序标志(00189),F7W81_82:陀螺组合标志(00200),F7W85_86:星敏感器组合标志(00209),F7W89_90:星敏感器1A状态字2(00218),F7W93_94:星敏感器1B状态字2(00226),F7W97_98:星敏感器3状态字(00233),F7W99_100:机动故障标志(00235),F7W101_102:成像方式标志(00238),F7W111:载荷成像主备工作方式(00258),F7W112:载荷成像工作模式控制(00259),F7W103_104:滚动机动控制标志(01010),F7W105_106:滚动机动加速计时(01014),F7W107_108:机动恢复计数(01020),F7W109_110:陀螺故障标志(01028),F7W113_114:可变参数4(01040),F7W115_116:可变参数5(01043),F7W117_118:可变参数6(01050),F7W79_80:姿态比较及选择标志(02456),F7W83_84:地平仪组合标志(02457),F7W87_88:星敏感器1A状态字1(02458),F7W91_92:星敏感器1B状态字1(02459),F7W95_96:星敏感器2状态字(02460),F7W109_112:卫星偏航角控制中间值(02733),F0W119_120:X正喷气计数(01051),F0W121_122:X负喷气计数(01064),F0W123_124:Y正喷气计数(01072),F0W125_126:Y负喷气计数(01081),F0W127_128:Z正喷气计数(01086),F0W129_130:Z负喷气计数(01099),F0W131_132:送相机gd角度(01105),F0W133_134:送相机ph角度(01116),F1W133_134:偏航90度机动标志(00325),F1W119_122:2陀螺X轴欧拉角速度(01058),F1W123_126:2陀螺Y轴欧拉角速度(01076),F1W127_130:2陀螺Z轴欧拉角速度(01092),W77_78:全姿态初态Y陀螺采样积分(01106),F1W131_132:送相机fy角度(02739),F2W119_122:软件星敏1A同步计数器(01059),F2W123_126:星敏1ASYNC信号计数(01077),F2W127_130:软件星敏1B同步计数器(01093),F2W131_134:星敏1BSYNC信号计数(01114),F30W65_68:星敏感器2测量的q0(01060),F30W69_72:星敏感器2测量的q1(01078),W73_76:星敏感器2测量的q2(01094),W77_80:星敏感器2测量的q3(01115),F3W131_132:星敏复位计数器(02778),F3W133_134:星敏2星图星号(02779),F4W119:飞轮电流Xa(00271),F4W120:飞轮温度Xa(00274),F4W121:飞轮电流Ya(00277),F4W122:飞轮温度Ya(00279),F4W123:飞轮电流Za(00281),F4W124:飞轮温度Za(00288),F4W125:飞轮电流Xb(00295),F4W126:飞轮温度Xb(00301),F4W127:飞轮电流Yb(00307),F4W128:飞轮温度Yb(00310),F4W129:飞轮电流Zb(00313),F4W130:飞轮温度Zb(00316),F4W131_132:模拟角计故障标志(01107),F4W133_134:初态程序流程(01117),F5W119_122:星敏感器2滚动姿态(01061),F5W123_126:星敏感器2俯仰姿态(01079),F5W127_130:星敏感器2偏航姿态(01095),F5W131_132:机动恢复标志(01108),F5W133_134:卫星速度(01118),F6W131_132:星下点经度(00319),F6W133_134:星下点纬度(00326),F6W119_120:可变参数7(01052),F6W121_122:可变参数8(01065),F6W123_124:可变参数9(01073),F6W125_126:可变参数10(01082),F6W127_128:可变参数11(01087),F6W129_130:可变参数12(01100),F7W119_122:X轴飞轮角动量(01062),F7W123_126:Y轴飞轮角动量(01080),F7W127_130:Z轴飞轮角动量(01096),F7W131_132:电池阵驱动角速度(01109),F7W133_134:星敏3星图星号(01119),F7W133_134:星敏3星图星号(02780),F8W119_122:实际轨道周期(01063),F8W123_124:天线驱动机构当前角度(01074),F8W125_126:横向像移速度(01083),F8W127_128:相机主镜组件温度(01088),F8W129_130:相机次镜组件温度(01101),F8W131_132:相机三镜组件温度(01110),F8W133_134:相机折叠镜组件温度(01120),F9W119_120:天计数(01053),F9W121_122:轨道圈数(01066),F9W123_124:数传天线机动角度1(01075),F9W125_126:像移速度参数(01084),F9W127_128:CCD焦平面温度(01089),F9W129_130:遮光罩正Y侧中部温度(01102),F9W131_132:遮光罩负Y侧中部温度(01111),F9W133_134:中部加强筋温度(01121),F10W123_124:数传天线机动角度2(00282),F10W124:电磁阀加热器1下限(00289),F10W119_120:指令队列读指针(01054),F10W121_122:指令队列写指针(01067),F10W125_126:纵向像移速度(01085),F10W127_128:负X面框架中部温度(01090),F10W129_130:正Y面框架上部温度(01103),F10W131_132:正Y面框架下部温度(01112),F10W133_134:负Y面框架上部温度(01122),F11W124:电磁阀加热器2下限(00290),F11W125:太阳角计A上限(00296),F11W126:太阳角计A下限(00302),F11W133:1通道工作状态(00327),F11W134:2通道工作状态(00332),F11W119_120:GPS校时门限(01055),F11W121_122:GPS校时间隔(01068),F11W127_128:负Y面框架下部温度(01091),F11W129_130:正Z面框架外部中间温度(01104),F11W131_132:负Z面框架外部中间温度(01113),F11W129_130:折迭镜镜背板中间温度(02469),F11W123_124:成像2时间长度(02737),F11W125_126:数据传输2时间长度(02738),F12W123:A电池补偿加热器1上限(00284),F12W124:A电池补偿加热器1下限(00291),F12W125:太阳角计B上限(00297),F12W126:太阳角计B下限(00303),F12W127:3通道工作状态(00308),F12W128:4通道工作状态(00311),F12W129:5通道工作状态(00314),F12W130:6通道工作状态(00317),F12W131:7通道工作状态(00320),F12W132:8通道工作状态(00323),F12W133:9通道工作状态(00328),F12W134:10通道工作状态(00333),F12W119_120:温控准禁标志(01056),F12W121_122:测温点选择标志(01069),F12W121B0:A推力器电磁阀壁温标志(01193),F12W121B1:B推力器电磁阀壁温标志(01194),F12W121B2:A组隔镍电池1测温温度标志(01195),F12W121B3:A组隔镍电池2测温温度标志(01196),F12W121B4:B组隔镍电池1测温温度标志(01197),F12W121B5:B组隔镍电池2测温温度标志(01198),F12W122B0:数传天线驱动机构A测温点标志(01201),F12W122B1:数传天线驱动机构B测温点标志(01202),F12W122B2:遥测探头测温点标志(01203),F12W122B115:(01204),F12W119B0: 允许电磁阀加热器1温控标志(01205),F12W119B1: 允许电磁阀加热器2温控标志(01206),F12W119B2:允许A组隔镍电池补偿加热器1温控标志(01207),F12W119B3:允许A组隔镍电池补偿加热器2温控标志(01208),F12W119B4:允许B组隔镍电池补偿加热器1温控标志(01209),F12W119B5:允许B组隔镍电池补偿加热器2温控标志(01210),F12W120B0:允许数传天线驱动机构加热器1温控标志(01213),F12W120B1:允许数传天线驱动机构加热器2温控标志(01214),F12W120B2:允许视频遥测探头加热器温控标志(01215),F12W120B115:(01216),F12W125_126:星敏感器1a头部温度(02770),F12W123_124:星敏感器1aCCD温度(02774),F13W123:A电池补偿加热器2上限(00285),F13W124:A电池补偿加热器2下限(00292),F13W125:数传天线加热器1上限(00298),F13W126:数传天线加热器1下限(00304),F13W127:11通道工作状态(00309),F13W128:12通道工作状态(00312),F13W129:13通道工作状态(00315),F13W130:14通道工作状态(00318),F13W131:15通道工作状态(00321),F13W132:16通道工作状态(00324),F13W133:17通道工作状态(00329),F13W134:相机通信标志(00334),F13W119_120:系统信息广播准禁标志(01057),F13W121_122:有效载荷数据采集标志(01070),F13W125_126:星敏感器1bCCD温度(02771),F13W123_124:星敏感器1a线路盒温度(02775),F14W119:驱动机构工作状态(00272),F14W120:天线驱动机构电机电流(00275),F14W123:B电池补偿加热器1上限(00286),F14W124:B电池补偿加热器1下限(00293),F14W125:数传天线加热器2上限(00299),F14W126:数传天线加热器2下限(00305),F14W121_122:天线预定角(01071),F14W133_134:摄像日期(01123),F14W127:1成像单元CCD+6V状态(02294),F14W128:2成像单元CCD+6V状态(02298),F14W129:3成像单元CCD+6V状态(02302),F14W130:4成像单元CCD+6V状态(02306),F14W130B50:12通道+6V状态(02307),F14W130B84:11通道+6V状态(02308),F14W130B118:10通道+6V状态(02309),F14W131:未定义(02310),F14W132:6成像单元CCD+6V状态(02314),F14W131:5成像单元CCD+6V状态(02360),F14W119B64:未定义(02467),F14W119B117:驱动机构工作状态(02468),F14W125_126:星敏感器1b线路盒温度(02772),F14W123_124:星敏感器1b头部温度(02776),F15W119:可用延时间接指令数(00273),F15W120:可用延时传送指令数(00276),F15W121:系统钟轨道钟计数差(00278),F15W123:B电池补偿加热器2上限(00287),F15W124:B电池补偿加热器2下限(00294),F15W125:视频探头加热器上限(00300),F15W126:视频探头加热器下限(00306),F15W133_134:程控状态标志(01124),F15W131:5成像单元CCD+17V状态(02334),F15W132:6成像单元CCD+17V状态(02338),F14W127:1成像单元CCD+17V状态(02362),F15W128:2成像单元CCD+17V状态(02363),F15W129:3成像单元CCD+17V状态(02364),F15W130:4成像单元CCD+17V状态(02365),F15W131:5成像单元CCD+17V状态(02366),F15W132:6成像单元CCD+17V状态(02367),F15W133B0:扩频应答机程控复位标志(02740),F15W133B1:中继收发设备程控复位标志(02741),F15W133B2:数传天线驱动器通信标志(02742),F15W133B3:公共辅助数据发送标志(02743),F15W133B4:成像程控时遥测记录1:2切换标志(02744),F15W133B5:遥测通道复用标志(02745),F15W133B6:应急程控关机准禁标志(02746),F15W133B7:0(02747),F15W125_126:星敏感器3通讯错误标志(02773),F15W123_124:星敏感器2通讯错误标志(02777)";
		//姿控分系统
		String str2 = "W225:-Y太阳角计信号1(00435),W226:-Y太阳角计信号2(00436),F4W170:星敏感器1a供电状态(00649),F5W170:星敏感器1b供电状态(00650),F6W170:俯仰地平仪二次电源状态(00651),F7W170:滚动地平仪二次电源状态(00652),F12W170:星敏感器2二次电源状态(00657),F5W174:陀螺信号变换器二次电源状态(00669),F6W174:星敏感器3二次电源状态(00670),F12W174:飞轮a供电状态(00676),F13W174:飞轮b供电状态(00677),F14W174:飞轮c供电状态(00678),F5W178:飞轮d供电状态(00688),F6W178:飞轮e供电状态(00689),F7W178:飞轮f供电状态(00690),F8W178:磁力矩器X供电状态(00691),F9W178:磁力矩器Y供电状态(00692),F10W178:磁力矩器Z供电状态(00693),W199:陀螺a1X轴姿态角速率(00794),W200:陀螺a1Y轴姿态角速率(00795),W201:陀螺a1Z轴姿态角速率(00796),W203:陀螺a2X轴姿态角速率(00829),W204:陀螺a2Y轴姿态角速率(00830),W205:陀螺a2Z轴姿态角速率(00831),F26W206:星敏感器2CCD冷端温度(00858),F27W206:俯仰地平仪探头壁温(00859),F28W206:滚动地平仪探头壁温(00860),W207:陀螺b1X轴姿态角速率(00864),W208:陀螺b1Y轴姿态角速率(00865),W209:陀螺b1Z轴姿态角速率(00866),F0W210:星敏感器1A对地通断状态(00867),F1W210:星敏感器1B对地通断状态(00868),W211:磁力矩器X正磁电流(00899),W212:磁力矩器Y正磁电流(00900),W213:磁力矩器Z正磁电流(00901),F3W214:陀螺b2温度(00905),F23W214:陀螺a1温度(00925),F24W214:陀螺a2温度(00926),F25W214:陀螺b1温度(00927),W215:磁力矩器X负磁电流(00934),W216:磁力矩器Y负磁电流(00935),W217:磁力矩器Z负磁电流(00936),F22W218:备用温控测温2(00959),F24W218:星敏感器3CCD冷端温度(00961),F27W218:陀螺信号变换器温度(00964),W219:+Y太阳角计信号1(00969),W220:+Y太阳角计信号2(00970)"; 
		//姿控动力学
		String str3 = "采集数据01:无意义(16001),采集数据02:无意义(16002),采集数据03:滚动电源+12V(16003),采集数据04:滚动电源-12V(16004),采集数据05:俯仰电源+12V(16005),采集数据06:俯仰电源-12V(16006),采集数据07:1a直流电源-15V(16007),采集数据08:1a直流电源+15V(16008),采集数据09:1b直流电源-15V(16009),采集数据10:1b直流电源+15V(16010),采集数据11:2直流电源-15V(16011),采集数据12:2直流电源+15V(16012),采集数据13:滚动太阳出现信号(16013),采集数据14:滚动电源+5V(16014),采集数据15:俯仰电源+5V(16015),采集数据16:1a滚动陀螺信号输出(16016),采集数据17:1a俯仰陀螺信号输出(16017),采集数据18:1a偏航陀螺信号输出(16018),采集数据19:1b滚动陀螺信号输出(16019),采集数据20:1b俯仰陀螺信号输出(16020),采集数据21:1b偏航陀螺信号输出(16021),采集数据22:2滚动陀螺信号输出(16022),采集数据23:2俯仰陀螺信号输出(16023),采集数据24:2偏航陀螺信号输出(16024),采集数据25:飞轮a电机电流(16025),采集数据26:飞轮a电源+5V(16026),采集数据27:飞轮b电机电流(16027),采集数据28:飞轮b电源+5V(16028),采集数据29:飞轮c电机电流(16029),采集数据30:飞轮c电源+5V(16030),采集数据31:飞轮d电机电流(16031),采集数据32:飞轮d电源+5V(16032),采集数据33:飞轮e电机电流(16033),采集数据34:飞轮e电源+5V(16034),采集数据35:飞轮f电机电流(16035),采集数据36:飞轮f电源+5V(16036),采集数据37:磁力矩器电流+a检测(16037),采集数据38:磁力矩器电流-a检测(16038),采集数据39:磁力矩器电流+b检测(16039),采集数据40:磁力矩器电流-b检测(16040),采集数据41:磁力矩器电流+c检测(16041),采集数据42:磁力矩器电流-c检测(16042),采集数据43:A机秒信号(16043),采集数据44:B机秒信号(16044),采集数据45:A机正常信号(16045),采集数据46:B机正常信号(16046),采集数据47:准/禁自主状态(16047),采集数据48:A/B机控制权状态(16048),采集数据49:A机开/关状态(16049),采集数据50:B机开/关状态(16050),采集数据51:公共+5V(16051),采集数据52:磁力矩器电流+a(16052),采集数据53:磁力矩器电流-a(16053),采集数据54:磁力矩器电流+b(16054),采集数据55:磁力矩器电流-b(16055),采集数据56:磁力矩器电流+c(16056),采集数据57:磁力矩器电流-c(16057),采集数据58:磁力矩器a供电状态(16058),采集数据59:磁力矩器b供电状态(16059),采集数据60:磁力矩器c供电状态(16060),采集数据61:飞轮a供电状态(16061),采集数据62:飞轮b供电状态(16062),采集数据63:飞轮c供电状态(16063),采集数据64:飞轮d供电状态(16064),采集数据65:飞轮e供电状态(16065),采集数据66:飞轮f供电状态(16066),采集数据67:滚动地平仪二次电源状态(16067),采集数据68:俯仰地平仪二次电源状态(16068),采集数据69:星敏感器1a供电状态(16069),采集数据70:星敏感器1b供电状态(16070),采集数据71:星敏感器2二次电源5V状态(16071),采集数据72:无意义(16072),采集数据73:自锁阀AKQJC(16073),采集数据74:自锁阀AGQJC(16074),采集数据75:陀螺1a X轴角速率遥测(16075),采集数据76:陀螺1a Y轴角速率遥测(16076),采集数据77:陀螺1a Z轴角速率遥测(16077),采集数据78:陀螺1a供电状态(16078),采集数据79:陀螺1b X轴角速率遥测(16079),采集数据80:陀螺1b Y轴角速率遥测(16080),采集数据81:陀螺1b Z轴角速率遥测(16081),采集数据82:陀螺1b供电状态(16082),采集数据83:陀螺2 X轴角速率遥测(16083),采集数据84:陀螺2 Y轴角速率遥测(16084),采集数据85:陀螺2 Z轴角速率遥测(16085),采集数据86:陀螺2供电状态(16086),采集数据87:模拟太阳角计a信号1(16087),采集数据88:模拟太阳角计a信号2(16088),采集数据89:模拟太阳角计b信号1(16089),采集数据90:模拟太阳角计b信号2(16090),采集数据91:数字太阳角计a二次电源状态(16091),采集数据92:数字太阳角计b二次电源状态(16092),采集数据93:主份推力器加热器1开关状态(16093),采集数据94:主份推力器加热器2开关状态(16094),采集数据95:主份推力器加热器3开关状态(16095),采集数据96:备份推力器加热器1开关状态(16096),采集数据97:备份推力器加热器2开关状态(16097),采集数据98:备份推力器加热器3开关状态(16098),采集数据99:主份电磁阀供电状态(16099),采集数据100:备份电磁阀供电状态(16100),采集数据101:自锁阀供电开关状态(16101),采集数据102:自锁阀位置显示二次电源(16102),采集数据103:一维驱动a二次电源状态(16103),采集数据104:一维驱动b二次电源状态(16104),采集数据105:自锁阀BKQJC(16105),采集数据106:自锁阀BGQJC(16106),采集数据107:飞轮A转速(16107),采集数据108:飞轮B转速(16108),采集数据109:飞轮C转速(16109),采集数据110:飞轮D转速(16110),采集数据111:飞轮E转速(16111),采集数据112:飞轮F转速(16112),采集数据113:转动机构1转速(16113),采集数据114:转动机构2转速(16114),采集数据115:无意义(16115),采集数据116:无意义 (16116),采集数据117:电磁阀A1QJC宽度(16117),采集数据118:电磁阀A2QJC宽度(16118),采集数据119:电磁阀A3QJC宽度(16119),采集数据120:电磁阀A4QJC宽度(16120),采集数据121:电磁阀A5QJC宽度(16121),采集数据122:电磁阀A6QJC宽度(16122),采集数据123:电磁阀A7QJC宽度(16123),采集数据124:电磁阀A8QJC宽度(16124),采集数据125:电磁阀B1QJC宽度(16125),采集数据126:电磁阀B2QJC宽度(16126),采集数据127:电磁阀B3QJC宽度(16127),采集数据128:电磁阀B4QJC宽度(16128),采集数据129:电磁阀B5QJC宽度(16129),采集数据130:电磁阀B6QJC宽度(16130),采集数据131:电磁阀B7QJC宽度(16131),采集数据132:电磁阀B8QJC宽度(16132),采集数据133:滚动左弦宽(16133),采集数据134:滚动右弦宽(16134),采集数据135:俯仰左弦宽(16135),采集数据136:俯仰右弦宽(16136),采集数据137:电磁阀A1QJC喷气次数(16137),采集数据138:电磁阀A2QJC喷气次数(16138),采集数据139:电磁阀A3QJC喷气次数(16139),采集数据140:电磁阀A4QJC喷气次数(16140),采集数据141:电磁阀A5QJC喷气次数(16141),采集数据142:电磁阀A6QJC喷气次数(16142),采集数据143:电磁阀A7QJC喷气次数(16143),采集数据144:电磁阀A8QJC喷气次数(16144),采集数据145:电磁阀B1QJC喷气次数(16145),采集数据146:电磁阀B2QJC喷气次数(16146),采集数据147:电磁阀B3QJC喷气次数(16147),采集数据148:电磁阀B4QJC喷气次数(16148),采集数据149:电磁阀B5QJC喷气次数(16149),采集数据150:电磁阀B6QJC喷气次数(16150),采集数据151:电磁阀B7QJC喷气次数(16151),采集数据152:电磁阀B8QJC喷气次数(16152),采集数据153:无意义(16153),采集数据154:无意义(16154),采集数据155:无意义(16155),采集数据156:无意义(16156),动力学01:无意义(16157),动力学02:无意义(16158),动力学03:卫星惯性位置X分量(16159),动力学04:卫星惯性位置Y分量(16160),动力学05:卫星惯性位置Z分量(16161),动力学06:卫星惯性速度X轴分量(16162),动力学07:卫星惯性速度Y轴分量(16163),动力学08:卫星惯性速度Z轴分量(16164),动力学09:仿真时刻(16165),动力学10:半长轴a(16166),动力学11:重力梯度力矩X分量(16167),动力学12:重力梯度力矩Y分量(16168),动力学13:重力梯度力矩Z分量(16169),动力学14:太阳光压干扰力矩X分量(16170),动力学15:太阳光压干扰力矩Y分量(16171),动力学16:太阳光压干扰力矩Z分量(16172),动力学17:地磁干扰力矩X分量(16173),动力学18:地磁干扰力矩Y分量(16174),动力学19:地磁干扰力矩Z分量(16175),动力学20:大气干扰力矩X分量(16176),动力学21:大气干扰力矩Y分量(16177),动力学22:大气干扰力矩Z分量(16178),动力学23:飞轮反作用力矩x分量(16179),动力学24:飞轮反作用力矩y分量(16180),动力学25:飞轮反作用力矩z分量(16181),动力学26:磁控力矩X分量(16182),动力学27:磁控力矩Y分量(16183),动力学28:磁控力矩Z分量(16184),动力学29:惯性x轴角速度真值ωx(16185),动力学30:惯性y轴角速度真值ωy(16186),动力学31:惯性z轴角速度真值ωz(16187),动力学32:轨道系滚动欧拉角速度真值dφz(16188),动力学33:轨道系俯仰欧拉角速度真值dθz(16189),动力学34:轨道系偏航欧拉角速度真值dψz(16190),动力学35:惯性系欧拉角速率真值dRn（对应三轴转台内框指令角速率）(16191),动力学36:惯性系欧拉角速率真值dRz（对应三轴转台中框指令角速率）(16192),动力学37:惯性系欧拉角速率真值dRw（对应三轴转台外框指令角速率）(16193),动力学38:惯性姿态四元数q0(16194),动力学39:惯性姿态四元数q1(16195),动力学40:惯性姿态四元数q2(16196),动力学41:惯性姿态四元数q3(16197),动力学42:轨道系滚动欧拉角真值φz(16198),动力学43:轨道系俯仰欧拉角真值θz(16199),动力学44:轨道系偏航欧拉角真值ψz(16200),动力学45:惯性系欧拉角真值Rn（对应三轴转台内框指令角）(16201),动力学46:惯性系欧拉角真值Rz（对应三轴转台中框指令角）(16202),动力学47:惯性系欧拉角真值Rw（对应三轴转台外框指令角）(16203),动力学48:偏心率e(16204),动力学49:轨道倾角i(16205),动力学50:升交点赤经Ω(16206),动力学51:近地点幅角ω(16207),动力学52:真近点角f(16208),动力学53:纬度幅角u(16209),动力学54:平近点角M(16210),动力学55:轨道角速度n(16211),动力学56:格林尼治恒星时Sg(16212),动力学57:星下点经度(16213),动力学58:星下点纬度(16214),动力学59:轨道系太阳投影x分量(16215),动力学60:轨道系太阳投影y分量(16216),动力学61:轨道系太阳投影z分量(16217),动力学62:飞轮A转速(16218),动力学63:飞轮B转速(16219),动力学64:飞轮C转速(16220),动力学65:飞轮D转速(16221),动力学66:飞轮E转速(16222),动力学67:飞轮F转速(16223),动力学68:地磁场轨道系X分量(16224),动力学69:地磁场轨道系Y分量(16225),动力学70:地磁场轨道系Z分量(16226),动力学71:X轴磁电流(16227),动力学72:Y轴磁电流(16228),动力学73:Z轴磁电流(16229),动力学74:帆板1转角(16230),动力学75:帆板2转角(16231),动力学76:当前天内毫秒计数(16232),动力学77:轨道钟(16233),动力学78:当前天(16234),动力学79:阴影区标志（1：光照；0：阴影）(16235),动力学80:推力器A1最近一拍喷气宽度和(16236),动力学81:推力器A2最近一拍喷气宽度和(16237),动力学82:推力器A3最近一拍喷气宽度和(16238),动力学83:推力器A4最近一拍喷气宽度和(16239),动力学84:推力器A5最近一拍喷气宽度和(16240),动力学85:推力器A6最近一拍喷气宽度和(16241),动力学86:推力器A7最近一拍喷气宽度和(16242),动力学87:推力器A8最近一拍喷气宽度和(16243),动力学88:推力器B1最近一拍喷气宽度和(16244),动力学89:推力器B2最近一拍喷气宽度和(16245),动力学90:推力器B3最近一拍喷气宽度和(16246),动力学91:推力器B4最近一拍喷气宽度和(16247),动力学92:推力器B5最近一拍喷气宽度和(16248),动力学93:推力器B6最近一拍喷气宽度和(16249),动力学94:推力器B7最近一拍喷气宽度和(16250),动力学95:推力器B8最近一拍喷气宽度和(16251)";
		
		String str4 = "F10W111:飞轮电流Xa(00814),F10W113:飞轮电流Ya(00816),F10W115:飞轮电流Za(00818),F10W117:飞轮电流Xb(00820),F10W119:飞轮电流Yb(00822),F10W121:飞轮电流Zb(00824),F10W112:飞轮温度Xa(00815),F10W114:飞轮温度Ya(00817),F10W116:飞轮温度Za(00819),F10W118:飞轮温度Xb(00821),F10W120:飞轮温度Yb(00823),F10W122:飞轮温度Zb(00825),F5W71_74:飞轮转速Xa(00423),F5W75_78:飞轮转速Ya(00424),F5W79_82:飞轮转速Za(00425),F5W83_86:飞轮转速Xb(00426),F5W87_90:飞轮转速Yb(00427),F5W91_94:飞轮转速Zb(00428)";
		StringBuffer propertySB = new StringBuffer();
		String[] strs = str4.split(",");
		for (String item : strs) {
//			String source = item.substring(item.indexOf(":") + 1, item.indexOf("("));
			String num = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
			propertySB.append("public String sequence_" + num + " = \"" + item + "\";" +"\n");
		}
		System.out.println(propertySB.toString());
	}
	@Test
	public void read() {
		try {
			long begin = System.currentTimeMillis();
			File file = new File("C:\\result.csv");
			InputStream in = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(in, "gb2312");
			BufferedReader reader = new BufferedReader(inputStreamReader);// 换成你的文件名
			String line1 = reader.readLine();// 第一行信息，为标题信息，不用,如果需要，注释掉
//			System.out.println(line1);
			String[] array = line1.split(",");
			String line = null;
			int count = 1;
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			Map<String,String> map = null;
			String date = "";
			while ((line = reader.readLine()) != null) {
//				if(count  == 5){
//					break;
//				}
//				System.out.println(line);
				map = new HashMap<String,String>();
				String[] items = line.split(",");
				date = items[0];
				map.put("year", DateUtil.formatString(date, "yyyy"));
				map.put("month", DateUtil.formatString(date, "yyyy-MM"));
				map.put("date", DateUtil.formatString(date, "yyyy-MM-dd"));
				for (int i = 0; i < items.length; i++) {
//					System.out.println(array[i] + ": " + FlyWheelDataType.getFlyWheelDataType(array[i]).getName()+ ":" + items[i]);
					map.put(FlyWheelDataType.getFlyWheelDataTypeByZh(array[i]).getName(), items[i]);
				}
				list.add(map);
//				System.out.println();
//					String str = new String(line.getBytes()); 
//					System.out.println(str);
				count ++;
				// String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
				// String last = item[item.length-1];//这就是你要的数据了
				// //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
				// System.out.println(last);8922448
			}
			System.out.println("size: " + list.size());
			System.out.println(JSON.toJSONString(list).length());
			long end = System.currentTimeMillis();
			System.out.println((end - begin));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void readToJSon() {
		try {
			long begin = System.currentTimeMillis();
			File file = new File("C:\\result.csv");
			InputStream in = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(in, "gb2312");
			BufferedReader reader = new BufferedReader(inputStreamReader);// 换成你的文件名
			String line1 = reader.readLine();// 第一行信息，为标题信息，不用,如果需要，注释掉
//			System.out.println(line1);
			String[] array = line1.split(",");
			String line = null;
			int count = 1;
			String date = "";
			String resultJson = "";
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			while ((line = reader.readLine()) != null) {
//				if(count  == 3){
//					break;
//				}
//				System.out.println(line);
				String[] items = line.split(",");
				date = items[0];
				resultJson = resultJson + "{";
				resultJson =  resultJson + "\"year\":" + "\"" + DateUtil.formatString(date, "yyyy") + "\","; 
				resultJson =  resultJson + "\"month\":" + "\"" + DateUtil.formatString(date, "yyyy-MM") + "\","; 
				resultJson =  resultJson + "\"date\":" + "\"" + DateUtil.formatString(date, "yyyy-MM-dd") + "\","; 
				for (int i = 0; i < items.length; i++) {
//					System.out.println(array[i] + ": " + FlyWheelDataType.getFlyWheelDataType(array[i]).getName()+ ":" + items[i]);
					if(i + 1 == items.length){
						resultJson =  resultJson + "\""+ FlyWheelDataType.getFlyWheelDataTypeByZh(array[i]).getName() +"\":" + "\"" +items[i].trim() + "\""; 							
					}else{
						resultJson =  resultJson + "\""+ FlyWheelDataType.getFlyWheelDataTypeByZh(array[i]).getName() +"\":" + "\"" +items[i].trim() + "\","; 							
					}
				}
				resultJson =  resultJson + "},";
				sb.append(resultJson);
				resultJson = "";
				count ++;
			}
//			resultJson = resultJson.substring(0, resultJson.length() - 1);
//			resultJson =  resultJson + "]";
//			System.out.println(resultJson);8922449
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("]");
			System.out.println(sb.length());
			long end = System.currentTimeMillis();
			System.out.println((end - begin));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test(){
		String str = "";
//		str = "2015年08月10日00时14分57秒,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,211,72,43c87c,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,211,72,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,0.0000,";
//		str = "时间,采集数据25:飞轮a电机电流(16025),采集数据26:飞轮a电源+5V(16026),采集数据27:飞轮b电机电流(16027),采集数据28:飞轮b电源+5V(16028),采集数据29:飞轮c电机电流(16029),采集数据30:飞轮c电源+5V(16030),采集数据31:飞轮d电机电流(16031),采集数据32:飞轮d电源+5V(16032),采集数据33:飞轮e电机电流(16033),采集数据34:飞轮e电源+5V(16034),采集数据35:飞轮f电机电流(16035),采集数据36:飞轮f电源+5V(16036),采集数据61:飞轮a供电状态(16061),采集数据62:飞轮b供电状态(16062),采集数据63:飞轮c供电状态(16063),采集数据64:飞轮d供电状态(16064),采集数据65:飞轮e供电状态(16065),采集数据66:飞轮f供电状态(16066),采集数据107:飞轮A转速(16107),采集数据108:飞轮B转速(16108),采集数据109:飞轮C转速(16109),采集数据110:飞轮D转速(16110),采集数据111:飞轮E转速(16111),采集数据112:飞轮F转速(16112),动力学62:飞轮A转速(16218),动力学63:飞轮B转速(16219),动力学64:飞轮C转速(16220),动力学65:飞轮D转速(16221),动力学66:飞轮E转速(16222),动力学67:飞轮F转速(16223)";
		str = "j9-02--2015-08-10.csv";
		str = str.substring(0, str.lastIndexOf(".csv"));
		String[] array = str.split("--");
		for (String item : array) {
			System.out.println(item);
		}
		System.out.println(DateUtil.formatString(array[1], "yyyy-MM-dd", "yyyy"));
		System.out.println(DateUtil.formatString(array[1], "yyyy-MM-dd", "MM"));
		System.out.println(DateUtil.formatString(array[1], "yyyy-MM-dd", "dd"));
	}
	
	@Test
	public void writeJava(){
		StringBuffer sb = new StringBuffer();
		String str = "Flywheel a motor current";
		String[] array = str.split(" ");
		System.out.println(array.length);
		System.out.println(array[0]);
		String s = array[0].substring(0, 1).toLowerCase() + array[0].substring(1);
		for (int i = 1; i < array.length; i++) {
			s = s + array[i].substring(0, 1).toUpperCase() + array[i].substring(1);
		}
		System.out.println(s);
	}
	@Test
	public void getDate() throws ParseException{
		Date date = new java.text.SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").parse("2015年08月10日13时2分20秒");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.get(Calendar.YEAR));
		//月份是从0开始计数的
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
	}
	@Test
	public void getDate2(){
		String date = "2015年08月10日13时2分20秒";
		System.out.println(DateUtil.formatString(date, "yyyy"));
		System.out.println(DateUtil.formatString(date, "yyyy-MM"));
		System.out.println(DateUtil.formatString(date, "yyyy-MM-dd"));
//		System.out.println(DateUtil.formatString(date, "yyyy-MM-dd-HH"));
//		System.out.println(DateUtil.formatString(date, "yyyy-MM-dd-HH-mm"));
//		System.out.println(DateUtil.formatString(date, "yyyy-MM-dd-HH-mm-ss"));
	}
}
