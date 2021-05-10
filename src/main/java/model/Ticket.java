package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
  private String departFrom;
  private String departDate;
  private String arriveAt;
  private String seatType;
  private String ticketAmount;
<<<<<<< HEAD
=======
  private String status;
>>>>>>> 502a501aaf2e821a4a335fa4245701fe2c0f1467
}
