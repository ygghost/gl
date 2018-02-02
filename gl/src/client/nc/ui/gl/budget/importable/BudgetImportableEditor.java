package nc.ui.gl.budget.importable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import nc.itf.trade.excelimport.ExportDataInfo;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillData;
import nc.ui.pub.bill.BillItem;
import nc.ui.trade.excelimport.InputItem;
import nc.ui.trade.excelimport.InputItemCreator;
import nc.ui.trade.excelimport.inputitem.InputItemImpl;
import nc.ui.uif2.excelimport.DefaultUIF2ImportableEditor;
import nc.vo.gl.budget.BudgetBVO;
import nc.vo.gl.budget.BudgetVO;
import nc.vo.gl.budget.constant.BudgetConstant;
import nc.vo.pub.ExtendedAggregatedValueObject;

/**
 * 导入导出入口类
 * 
 */
public class BudgetImportableEditor extends DefaultUIF2ImportableEditor {

	/**
	 * 导出表头/表体/表尾项
	 */
	@Override
	public List<InputItem> getInputItems() {
		displayPanelItem(true);
		List<InputItem> inputItemList = InputItemCreator.getInputItems(
				getEditorBillData(), false);
		processRequiredItems(inputItemList);
		return inputItemList;
	}

	/**
	 * 导出数据
	 */
	@Override
	public ExportDataInfo getValue(List<InputItem> exportItems) {
		processExportItem();
		Object[] vos = getSelectedObject();
		BillData billData = this.getEditorBillData();
		ExtendedAggregatedValueObject[] aggvos = getDataConvertor()
				.convertDataFromEditorData(billData, vos, exportItems);
		return new ExportDataInfo(beforeExport(aggvos));
	}

	/**
	 * 导入数据
	 */
	@Override
	public void setValue(Object obj) {
		// TODO 自动生成的方法存根
		super.setValue(obj);
	}

	/**
	 * 设置显示的项
	 */
	public void displayPanelItem(boolean flag) {
		// 显示的字段列
		for (String fieldStr : this.getHeadItemsExport()) {
			// BillItem[] haadItems = this.getBillCardPanel().getHeadItems();
			BillItem headItem = this.getBillCardPanel().getHeadItem(fieldStr);
			if (null != headItem) {
				if (flag) {
					headItem.setShow(flag);
				}
			}
		}
		for (String fieldStr : this.getBodyItemsExport()) {
			BillItem bodyItem = this.getBillCardPanel().getBodyItem(fieldStr);
			if (null != bodyItem) {
				if (flag) {
					bodyItem.setShow(flag);
				}
			}
		}
	}

	/**
	 * 处理必要项
	 */
	public void processRequiredItems(List<InputItem> items) {
		Iterator<InputItem> iterator = items.iterator();
		while (iterator.hasNext()) {
			InputItem item = iterator.next();
			if (BudgetConstant.IMPORT_NOTMETA.contains(item.getItemKey())) {
				iterator.remove();
			} else {

				String tabCode = item.getTabCode();
				String itemKey = item.getItemKey();
				boolean isRequired = item.isNotNull();
				boolean isShowed = item.isShow();
				boolean isEdited = item.isEdit();

				switch (tabCode) {
				case BudgetConstant.IMPORT_HEAD:
					if (this.getHeadItemsExport().contains(itemKey)
							|| (isRequired && isShowed && isEdited)) {
						// 设置为必选项
						InputItemImpl newItem = InputItemImpl
								.getEquivalent(item);
						newItem.setEdit(true);
						newItem.setNotNull(true);
						items.set(items.indexOf(item), newItem);
					} else {
						// 设置为待选项
						InputItemImpl newItem = InputItemImpl
								.getEquivalent(item);
						newItem.setEdit(true);
						newItem.setNotNull(false);
						items.set(items.indexOf(item), newItem);
					}
					break;
				case BudgetConstant.IMPORT_BODY:
					if (this.getBodyItemsExport().contains(itemKey)
							|| (isRequired && isShowed && isEdited)) {
						// 设置为必选项
						InputItemImpl newItem = InputItemImpl
								.getEquivalent(item);
						newItem.setEdit(true);
						newItem.setNotNull(true);
						items.set(items.indexOf(item), newItem);
					} else {
						// 设置为待选项
						InputItemImpl newItem = InputItemImpl
								.getEquivalent(item);
						newItem.setEdit(true);
						newItem.setNotNull(false);
						items.set(items.indexOf(item), newItem);
					}
					break;
				case BudgetConstant.IMPORT_TAILER:
					// 设置为待选项
					InputItemImpl newItem = InputItemImpl.getEquivalent(item);
					newItem.setEdit(true);
					newItem.setNotNull(false);
					items.set(items.indexOf(item), newItem);
					break;
				default:
					// 剔除表尾审计信息项以及其他无需项目
					/*
					 * InputItemImpl newItem =
					 * InputItemImpl.getEquivalent(item);
					 * newItem.setEdit(false); newItem.setNotNull(false);
					 * items.set(items.indexOf(item), newItem);
					 */
					break;
				}
			}
		}
	}

	/**
	 * 处理导出项
	 */
	public void processExportItem() {
		/*
		 * try { // 物料关联元数据报错， 不需要关联项目， 所以调用反射清除 BillItem matrilItem =
		 * this.getBillCardPanel().getBodyItem( BudgetBVO.CPRODID); if
		 * (matrilItem != null) { Field declaredField = BillItem.class
		 * .getDeclaredField(BudgetConstant.IMPORT_METADATARELATION);
		 * declaredField.setAccessible(true); declaredField.set(matrilItem,
		 * null); }
		 * 
		 * } catch (NoSuchFieldException e) {
		 * ExceptionHandler.handleRuntimeException(e); } catch (Exception e) {
		 * ExceptionHandler.consume(e); }
		 */
	}

	private BillCardPanel getBillCardPanel() {
		return getBillcardPanelEditor().getBillCardPanel() == null ? null
				: getBillcardPanelEditor().getBillCardPanel();
	}

	private BillData getEditorBillData() {
		return this.getBillCardPanel() == null ? null : this.getBillCardPanel()
				.getBillData();
	}

	/**
	 * 指定表头必选字段
	 * 
	 * @return
	 */
	private List<String> getHeadItemsExport() {
		List<String> headItemsExport = Arrays.asList(new String[] {
				BudgetVO.PK_ORG, BudgetVO.DBILLDATE, BudgetVO.BPERIOD });
		List<String> headItemsExport1 = Arrays
				.asList(new String[] { BudgetVO.PK_ORG, BudgetVO.DBILLDATE,
						BudgetVO.BPERIOD, BudgetVO.CPRODID, BudgetVO.DEF1,
						BudgetVO.DEF2, BudgetVO.DEF3 });
		List<String> defaultHeadItemsExport = Arrays
				.asList(new String[] { BudgetVO.PK_ORG, BudgetVO.DBILLDATE,
						BudgetVO.BPERIOD, BudgetVO.CPRODID, BudgetVO.DEF1,
						BudgetVO.DEF2, BudgetVO.DEF3 });

		String nodeCode = this.getAppModel().getContext().getNodeCode();
		List<String> headItems = Arrays.asList(new String[] {});
		switch (nodeCode) {
		case BudgetConstant.YSDYX_FUNCODE:
		case BudgetConstant.YSDCG_FUNCODE:
		case BudgetConstant.YSDCW_FUNCODE:
		case BudgetConstant.YSDSC_FUNCODE:
			headItems = headItemsExport;
			break;
		case BudgetConstant.YSDGC_FUNCODE:
			headItems = headItemsExport1;
			break;
		default:
			headItems = defaultHeadItemsExport;
			break;
		}
		return headItems;
	}

	/**
	 * 指定表体必选字段
	 * 
	 * @return
	 */
	private List<String> getBodyItemsExport() {
		// 营销中心
		List<String> bodyItemsExport = Arrays.asList(new String[] {
				BudgetBVO.CPRODID, BudgetBVO.CUNITID, BudgetBVO.NNUM,
				BudgetBVO.NBLARGESSNUM, BudgetBVO.NPRICE, BudgetBVO.NDISCOUNT,
				BudgetBVO.NSALESCOST, BudgetBVO.NOUTSTORCOST, BudgetBVO.VBDEF1,
				BudgetBVO.VBDEF2, BudgetBVO.VBDEF3 });
		// 采购中心
		List<String> bodyItemsExport1 = Arrays.asList(new String[] {
				BudgetBVO.CMATERIALID, BudgetBVO.CUNITID, BudgetBVO.NPRICE
		/* ,BudgetBVO.VBDEF7, BudgetBVO.NNUM */});
		// 财务中心
		List<String> bodyItemsExport2 = Arrays.asList(new String[] {
				BudgetBVO.CPRODID, BudgetBVO.CUNITID, BudgetBVO.NPACKINGCHARGE,
				BudgetBVO.VBDEF1, BudgetBVO.VBDEF2, BudgetBVO.VBDEF3,
				BudgetBVO.VBDEF4, BudgetBVO.VBDEF5, BudgetBVO.VBDEF6 });
		// 工程中心
		List<String> bodyItemsExport3 = Arrays.asList(new String[] {
				BudgetBVO.CMATERIALID, BudgetBVO.CUNITID, BudgetBVO.NNUM });
		// 生产中心
		List<String> bodyItemsExport4 = Arrays.asList(new String[] {
				BudgetBVO.CPRODID, BudgetBVO.CUNITID, BudgetBVO.NNUM,
				BudgetBVO.NCOST1, BudgetBVO.NCOST2, BudgetBVO.NCOST3,
				BudgetBVO.NCOST4, BudgetBVO.NCOST5, BudgetBVO.NCOST6,
				BudgetBVO.VBDEF1, BudgetBVO.VBDEF2, BudgetBVO.VBDEF3 });
		// 默认
		List<String> defaultBodyItemsExport = Arrays.asList(new String[] {
				BudgetBVO.CPRODID, BudgetBVO.CMATERIALID, BudgetBVO.CUNITID,
				BudgetBVO.NNUM, BudgetBVO.NBLARGESSNUM, BudgetBVO.NPRICE,
				BudgetBVO.NDISCOUNT, BudgetBVO.NSALESCOST,
				BudgetBVO.NOUTSTORCOST, BudgetBVO.NPRICE,
				BudgetBVO.NPACKINGCHARGE, BudgetBVO.VBDEF1, BudgetBVO.VBDEF2,
				BudgetBVO.VBDEF3 });

		String nodeCode = this.getAppModel().getContext().getNodeCode();
		List<String> bodyItems = Arrays.asList(new String[] {});
		switch (nodeCode) {
		case BudgetConstant.YSDYX_FUNCODE:
			bodyItems = bodyItemsExport;
			break;
		case BudgetConstant.YSDCG_FUNCODE:
			bodyItems = bodyItemsExport1;
			break;
		case BudgetConstant.YSDCW_FUNCODE:
			bodyItems = bodyItemsExport2;
			break;
		case BudgetConstant.YSDGC_FUNCODE:
			bodyItems = bodyItemsExport3;
			break;
		case BudgetConstant.YSDSC_FUNCODE:
			bodyItems = bodyItemsExport4;
			break;
		default:
			bodyItems = defaultBodyItemsExport;
			break;
		}
		return bodyItems;
	}

}
