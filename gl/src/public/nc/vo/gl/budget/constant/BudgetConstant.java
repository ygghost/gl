package nc.vo.gl.budget.constant;

/**
 * 预算单常量类
 * 
 * @author yegz
 * @Date 2017-11-17
 * @since NC65
 */
public class BudgetConstant {

	/************* 预算单录入功能编码 **************/
	public static final String YSDLR_FUNCODE = "20028801";
	/************* 预算单(营销)功能编码 **************/
	public static final String YSDYX_FUNCODE = "20028802";
	/************* 预算单(工程)功能编码 **************/
	public static final String YSDGC_FUNCODE = "20028803";
	/************* 预算单(采购)功能编码 **************/
	public static final String YSDCG_FUNCODE = "20028804";
	/************* 预算单(生产)功能编码 **************/
	public static final String YSDSC_FUNCODE = "20028805";
	/************* 预算单(财务)功能编码 **************/
	public static final String YSDCW_FUNCODE = "20028806";

	/************* 预算单(营销)单据类型编码 **************/
	public static final String YSDYX_TYPECODE = "YSDJ-01";
	/************* 预算单(工程)单据类型编码 **************/
	public static final String YSDGC_TYPECODE = "YSDJ-02";
	/************* 预算单(采购)单据类型编码 **************/
	public static final String YSDCG_TYPECODE = "YSDJ-03";
	/************* 预算单(生产)单据类型编码 **************/
	public static final String YSDSC_TYPECODE = "YSDJ-04";
	/************* 预算单(财务)单据类型编码 **************/
	public static final String YSDCW_TYPECODE = "YSDJ-05";

	/************* 以下参数为导出导入功能所需 ***************/

	/** 界面使用的AppModel beanName字符串 */
	public static final String APPMODEL_BEAN_NAME = "ManageAppModel";

	/** 卡片编辑器 beanName */
	public static final String BIZCATOR_EDITOR_BEAN_NAME = "billFormEditor";

	/** AddAction beanName字符串 */
	public static final String ADD_ACTION_BEAN_NAME = "addAction";

	/** SaveAction beanName字符串 */
	public static final String SAVE_ACTION_BEAN_NAME = "saveAction";

	/** CancelAction beanName字符串 */
	public static final String CANCEL_ACTION_BEAN_NAME = "cancelAction";

	/** 表头页签编码 */
	public static final String IMPORT_HEAD = "budget";
	/** 表体页签编码 */
	public static final String IMPORT_BODY = "pk_budget_b";
	/** 表尾页签编码 */
	public static final String IMPORT_TAILER = "tailerInfo";
	/** 非元数据项 */
	public static final String IMPORT_NOTMETA = "pk_accperiod";

	/************* 以上参数为导出功能所需 *****************/

}
