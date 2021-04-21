import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.List;
import java.util.Random;

/**
 * Snowflake An improved version of the algorithm
 *
 * @author wsh
 * @version 1.0
 * @date 2019/7/31
 * @since JDK1.8
 */

/**
Timestamp: Take the number of milliseconds from January 1, 2018 to the present. Assuming that the system runs for at least 10 years, it will take at least 10 years, 365 days, 24 hours, 3600 seconds, 1000 milliseconds = 320*10^ 9. Almost 39 bits are reserved for milliseconds.
Business Line: 8bit
Machine: Automatically generated, reserved for 10 bits
Number in milliseconds: The peak concurrency per second is less than 10W, that is, the average peak concurrency per milliseconds is less than 100, almost 7 bits are reserved for the serial number per milliseconds.
| Timestamp  | Business Line | Machine | Serial Number in Milliseconds| 
| :timestamp | :service      | :worker | :sequence | 
| 39         | 8             | 10      | 7         |

**/


public class Snowflake {

     * Number of digits occupied by business line id
     **/
    private final long serviceIdBits = 8L;
    /**
     * Maximum data identifier ID supported by line of business identification (this shift algorithm can quickly calculate the maximum decimal number represented by several bits of binary number)
     */
    private final long maxServiceId = -1L ^ (-1L << serviceIdBits);
    private final long serviceId;


    /**
     * Number of digits occupied by machine id
     **/
    private final long workerIdBits = 10L;
    /**
     * Maximum machine id supported
     */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long workerId;


    /**
     * Number of digits in id of sequence
     **/
    private final long sequenceBits = 7L;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);


    /**
     * Start time stamp (January 1, 2018)
     **/
    private final long twepoch = 1514736000000L;
    /**
     * Last timestamp
     **/
    private volatile long lastTimestamp = -1L;
    /**
     * Sequence in milliseconds
     **/
    private volatile long sequence = 0L;
    /**
     * random number generator
     **/
    private static volatile Random random = new Random();


    /**
     * Left shift number of machine id
     **/
    private final long workerIdShift = sequenceBits;
    /**
     * Left shift number of line id
     **/
    private final long serviceIdShift = workerIdBits + sequenceBits;
    /**
     * Time stamp left shift number
     **/
    private final long timestampLeftShift = serviceIdBits + workerIdBits + sequenceBits;

    public SnowflakeIdGenerator(long serviceId) {
        if ((serviceId > maxServiceId) || (serviceId < 0)) {
            throw new IllegalArgumentException(String.format("service Id can't be greater than %d or less than 0", maxServiceId));
        }
        workerId = getWorkerId();
        if ((workerId > maxWorkerId) || (workerId < 0)) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.serviceId = serviceId;
    }

    public synchronized long nextId() throws IdsException {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new IdsException("Clock moved backwards.  Refusing to generate id for " + (
                    lastTimestamp - timestamp) + " milliseconds.");
        }
        //If it is generated at the same time, the sequence in milliseconds is performed.
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //When crossing milliseconds, the serial number always returns to zero, which leads to more IDs with the serial number of 0, resulting in the uneven generation of ID after taking the model, so the random number within 10 is adopted.
            sequence = random.nextInt(10) & sequenceMask;
        }
        //Time Interception of Last ID Generation (Setting Last Time Stamp)
        lastTimestamp = timestamp;

        //Shift and assemble 64-bit ID s together by operation or operation
        return ((timestamp - twepoch) << timestampLeftShift) //time stamp
                | (serviceId << serviceIdShift) //Business Line
                | (workerId << workerIdShift) //machine
                | sequence; //Serial number
    }

    /**
     * Waiting for the next millisecond to arrive, make sure that the number of milliseconds returned is after the parameter lastTimestamp
     * Keep acquiring time until it is greater than the last time.
     */
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    /**
     * According to the MAC address of the machine, the working process Id can also be obtained by using the machine IP. The last two segments, a total of 10 bit s, can be obtained.
     * In extreme cases, if the last two segments of the MAC address are the same, the Id of the product will be the same; in extreme cases, if the concurrency is not large, the Id of the product will be repeated just across milliseconds and the random sequence is the same.
     *
     * @return
     * @throws IdsException
     */
    protected long getWorkerId() throws IdsException {
        try {
            java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface iface = en.nextElement();
                List<InterfaceAddress> addrs = iface.getInterfaceAddresses();
                for (InterfaceAddress addr : addrs) {
                    InetAddress ip = addr.getAddress();
                    NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                    if (network == null) {
                        continue;
                    }
                    byte[] mac = network.getHardwareAddress();
                    if (mac == null) {
                        continue;
                    }
                    long id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 11;
                    if (id > maxWorkerId) {
                        return new Random(maxWorkerId).nextInt();
                    }
                    return id;
                }
            }
            return new Random(maxWorkerId).nextInt();
        } catch (SocketException e) {
            throw new IdsException(e);
        }
    }

    /**
     * Get the serial number
     *
     * @param id
     * @return
     */
    public static Long getSequence(Long id) {
        String str = Long.toBinaryString(id);
        int size = str.length();
        String sequenceBinary = str.substring(size - 7, size);
        return Long.parseLong(sequenceBinary, 2);
    }

    /**
     * Access Machine
     *
     * @param id
     * @return
     */
    public static Long getWorker(Long id) {
        String str = Long.toBinaryString(id);
        int size = str.length();
        String sequenceBinary = str.substring(size - 7 - 10, size - 7);
        return Long.parseLong(sequenceBinary, 2);
    }

    /**
     * Acquisition of Business Lines
     *
     * @param id
     * @return
     */
    public static Long getService(Long id) {
        String str = Long.toBinaryString(id);
        int size = str.length();
        String sequenceBinary = str.substring(size - 7 - 10 - 8, size - 7 - 10);
        return Long.parseLong(sequenceBinary, 2);
    }

    
}
