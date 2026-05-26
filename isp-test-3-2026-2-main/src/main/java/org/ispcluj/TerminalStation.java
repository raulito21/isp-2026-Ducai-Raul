package org.ispcluj;

public class TerminalStation {
    //TODO: REQ-5
    public class TerminalStation {

        private static final int MAX_CAPACITY = 4;

        private final Queue<Train> terminalBuffer = new LinkedList<>();
        private final Set<String> registeredIds = new HashSet<>();

        private boolean acceptingTrains = true;
        private int processedTrains = 0;

        public synchronized void enqueueTrain(Train train) throws InterruptedException {
            if (train == null) {
                throw new TerminalOverloadException("Nu.");
            }

            if (registeredIds.contains(train.getId())) {
                System.out.println(" Dup.: " + train.getId());
                return;
            }

            while (terminalBuffer.size() >= MAX_CAPACITY) {
                System.out.println(" Full");
                wait();
            }

            terminalBuffer.add(train);
            registeredIds.add(train.getId());

            System.out.println(" adaugat: " + train);
            notifyAll();
        }

        public synchronized Train dequeueNextTrain(PlatformTrack track) throws InterruptedException {
            while (terminalBuffer.isEmpty() && acceptingTrains) {
                track.updateState(PlatformState.BLOCKED);
                wait();
            }

            if (terminalBuffer.isEmpty() && !acceptingTrains) {
                return null;
            }

            Train train = terminalBuffer.poll();
            notifyAll();
            return train;
        }

        public synchronized void markProcessed() {
            processedTrains++;
        }

        public synchronized int getProcessedTrains() {
            return processedTrains;
        }

        public synchronized int getUniqueTrainCount() {
            return registeredIds.size();
        }

        public synchronized boolean isEmpty() {
            return terminalBuffer.isEmpty();
        }

        public synchronized void closeStation() {
            acceptingTrains = false;
            notifyAll();
        }
}
