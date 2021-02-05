'''
this is just a data transfer tool
'''
import json
import mysql.connector


schema_name = 'loan'
table_names = [
    'loan',
    'loan_stats',
    'loan_operation_data',
    'loan_employment_data',
    'payment_fee_data',
    'payment_installment_data',
    'payment_option_data',
    ]

table_sql = {}


def transfer():

    print('>>>>>>>>>>>>> start <<<<<<<<<<<<<')
    try:
        dev = mysql.connector.connect(
            host="panda-mysql-dev3-2.cluster-ro-cdyrsmnel9xh.us-west-1.rds.amazonaws.com",
            port=3306,
            user="admin",
            passwd="pandamysql32",
            database="loan")
        
        
        local = mysql.connector.connect(
            host="172.18.1.245",
            port=3308,
            user="root",
            passwd="Arb@8888",
            database="loan")

        cursorDev = dev.cursor(dictionary=True)
        cursorLocal = local.cursor(dictionary=True)

        schemaSql = """ select group_concat(COLUMN_NAME) as fields from information_schema.COLUMNS where TABLE_SCHEMA = '{0}' and TABLE_NAME = '{1}' """

        for table in table_names:
            schemaSql = schemaSql.format(schema_name, table)
            cursorLocal.execute(schemaSql)
            result = cursorLocal.fetchone()
            fields = result['fields']
            sql = packReplaceIntoSql(table, fields)
            table_sql[table] = sql

        print('=================')
        print(table_sql)

        
        
        
        # for i in range(0, len(rows), 1000):
        #     cursorDev.executemany(sql, rows[i:i+1000])
        #     dev.commit()
            
    except Exception as e:
        print(' something bad happend ')
        print(e)
    finally:
        cursorDev.close()
        dev.close()        
        cursorLocal.close()        
        local.close()        
        print(" >>>>>>>>>>>> end <<<<<<<<<<<<<<")

def packReplaceIntoSql(table, fields):

    sql = ' replace into {0} values ({1}) on duplicate key update {2} '

    values = ','.join([ '%({0})s'.format(field) for field in fields.split(',')])

    updates = ','.join([ '{0} = VALUES(%({0})s)'.format(field, field) for field in fields.split(',')])
    
    return sql.format(table, values, updates)


if __name__ == '__main__':
    transfer()
