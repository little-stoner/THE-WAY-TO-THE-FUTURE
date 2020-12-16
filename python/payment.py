# -*- coding: utf-8 -*-
import csv
import codecs
import mysql.connector




def generateSql(table_name):
    fields = ''
    if table_name == 'payment':
        fields = 'application_id,application_no,collected_at,created_at,flags,phase,portfolio_id,state,status,application_type,parent_id,approved_amount,loan_amount,approved_at,stage'
    elif table_name == 'payment_calculate_data':
        fields = 'application_id,apr,last_debit_date,first_day_of_month,first_day_of_week,interest_rate,payday_on_available,payday_on_holiday,payroll_frequency,regular_amount,second_day_of_month,second_day_of_week,transaction_mode,last_payday,effective_date,debit_count,first_debit_date,expire_date,first_credit_date,ach_provider_id'
    elif table_name == 'payment_fee_data':
        fields = 'application_id,total_amount,total_principal,total_interest,total_late_fee,total_additional_fee,total_nsf_fee,total_bank_fee,total_discount_amount,total_discount_principal,total_discount_interest,total_discount_late_fee,total_discount_nsf_fee,total_discount_bank_fee,total_discount_additional_fee,total_paid_amount,total_paid_principal,total_paid_interest,total_paid_late_fee,total_paid_nsf_fee,total_paid_bank_fee,total_paid_additional_fee,total_unpaid_amount,total_unpaid_principal,total_unpaid_interest,total_unpaid_late_fee,total_unpaid_nsf_fee,total_unpaid_bank_fee,total_unpaid_additional_fee,total_unpaid_late_interest,total_paid_late_interest,total_late_interest,transferred_amount,total_discount_late_interest'
    elif table_name == 'payment_status_data':
        fields = 'application_id,application_status,application_status_text'
    elif table_name == 'pament_installment_data':
        fields = 'id,application_id,ach_provider_id,change_type,correct_data,flags,frozen_status,transaction_amount,additional_fee,amount,bank_fee,interest,late_fee,nsf_fee,principal,portfolio_id,operated_id,return_code,return_data,returned_at,status,transaction_date,transaction_failure_reason,transaction_flags,transaction_mode,transaction_no,transaction_status,transaction_type,thread_id,unpaid_fee,transaction_date_text'
    if len(fields) == 0:
        return None
    field_count = len(fields.split(','))
    values = '('
    for i in range(0, field_count -1):
        values += '%s,'
    values += '%s)'
    update_values = ''
    for field in fields.split(','):
        update_values += ' ' + field + '=VALUES(' + field + '), '
    sql = 'INSERT INTO ' + table_name + '('+fields +')' + ' VALUES ' + values + ' ON DUPLICATE KEY UPDATE ' + update_values[:-2]
    print(sql)
    return sql


def readCSV(file_name):
    data = []
    with open(file_name, newline='') as csvfile:
        spamreader = csv.reader(csvfile)
        for row in spamreader:
            for i in range(len(row)):
                if row[i] == 'NULL':
                    row[i] = None
            data.append(tuple(row))
    print(data)
    return data

def execute(sql, data):
    pass


if __name__ == '__main__':
    payment = '/Users/viber/Documents/payment_rel_v3_payment.csv'
    payment_calculate_data = '/Users/viber/Documents/payment_rel_v3_payment_calculate_data.csv'
    payment_fee_data = '/Users/viber/Documents/payment_rel_v3_payment_fee_data.csv'
    payment_status_data = '/Users/viber/Documents/payment_rel_v3_payment_status_data.csv'
    payment_installment_data = '/Users/viber/Documents/payment_rel_v3_payment_installment_data.csv'
    # database_connection = mysql.connector.connect(
    #     host="172.18.1.245",
    #     port=3307,
    #     user="root",
    #     passwd="Arb@8888",
    #     database="schedule")
    database_connection = mysql.connector.connect(
        host="panda-mysql-dev3-1-instance-1.cdyrsmnel9xh.us-west-1.rds.amazonaws.com",
        port=3306,
        user="admin",
        passwd="pandamysql31",
        database="schedule"
    )
    cursor = database_connection.cursor()
    print(".............. start ...................")
    cursor.executemany(generateSql('payment'), readCSV(payment))
    database_connection.commit()
    
    cursor.executemany(generateSql('payment_calculate_data'), readCSV(payment_calculate_data))
    database_connection.commit()

    cursor.executemany(generateSql('payment_fee_data'), readCSV(payment_fee_data))
    database_connection.commit()

    cursor.executemany(generateSql('payment_status_data'), readCSV(payment_status_data))
    database_connection.commit()

    cursor.executemany(generateSql('payment_installment_data'), readCSV(payment_installment_data))
    database_connection.commit()

    print('.............. finish ...............')
