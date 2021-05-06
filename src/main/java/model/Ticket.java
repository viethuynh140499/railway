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
  private String status;
}
