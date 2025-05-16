//Jesus
package com.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class IMedhas {
		
	class Transaction {
		Integer id;
		String status;
		List<String> metaData; // India, MerchantName, PRIORY
		Date date;
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		/**
		 * @return the metaData
		 */
		public List<String> getMetaData() {
			return metaData;
		}
		/**
		 * @param metaData the metaData to set
		 */
		public void setMetaData(List<String> metaData) {
			this.metaData = metaData;
		}
		/**
		 * @return the date
		 */
		public Date getDate() {
			return date;
		}
		/**
		 * @param date the date to set
		 */
		public void setDate(Date date) {
			this.date = date;
		}
	};
	
	
	
	

	public static void main(String[] args) {
		
		List<Transaction> allTransactions = new ArrayList<>();
		
		
		//Find country=India in the metadata, find oldest transaction.
		
		//if(metaData.contains("India"))
		Transaction oldestTxForIndia = allTransactions.stream().filter(t1 -> t1.metaData.contains("India"))
								.max(Comparator.comparing(Transaction::getDate)).orElse(null);
		
	}

}
