package util;

/**
 * @author Bourbon
 * @date 2018/4/8
 * @description
 */
public class VIPCalculator {

	/**
	 * @description 根据会员等级计算打折力度
	 * 每级打折10%，最高80%
	 */
	public static double calDiscountByViplevel(int viplevel) {
		double discount = viplevel / 10;
		discount = (discount > 0.8) ? 0.8 : discount;
		return discount;
	}

	/**
	 * @description 根据消费金额数量级计算会员等级
	 * 对10开方阶次
	 */
	public static int calViplevelFromConsumption(double consumption) {
		return (int) Math.pow(consumption, 0.1);
	}

	/**
	 * @description 根据消费金额计算对应积分获得
	 * 同等增加
	 */
	public static int calPointFromConsumption(double consumption) {
		return (int) consumption;
	}

	/**
	 * @description 根据积分计算兑换余额获得
	 * 100：1兑换余额
	 */
	public static double calChangeFromPoint(int point) {
		return point / 100;
	}
}